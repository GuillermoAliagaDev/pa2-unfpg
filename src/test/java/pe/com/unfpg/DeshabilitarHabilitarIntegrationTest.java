package pe.com.unfpg;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
    "spring.datasource.url=jdbc:h2:mem:test_delete_patch;MODE=MySQL;DB_CLOSE_DELAY=-1",
    "spring.datasource.driver-class-name=org.h2.Driver",
    "spring.datasource.username=sa", "spring.datasource.password=",
    "spring.jpa.hibernate.ddl-auto=create-drop", "spring.jpa.show-sql=false"
})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeshabilitarHabilitarIntegrationTest {
    @LocalServerPort
    int port;

    @Autowired
    JdbcTemplate jdbc;

    final HttpClient client = HttpClient.newHttpClient();

    @BeforeAll
    void prepararDatos() {
        jdbc.execute("INSERT INTO distrito (nomdis, estdis) VALUES ('San Isidro', TRUE)");
        jdbc.execute("INSERT INTO sexo (nomsex, estsex) VALUES ('Masculino', TRUE)");
        jdbc.execute("INSERT INTO tipodocumento (nomtipd, esttipd) VALUES ('DNI', TRUE)");
        jdbc.execute("INSERT INTO estadocivil (nomestc, estestc) VALUES ('Soltero', TRUE)");
        jdbc.execute("INSERT INTO alumno (nomalu, apepalu, apemalu, fecnac, numdoc, nacalu, diralu, telalu, celalu, coralu, estalu, crealu, coddis, codsex, codtipd, codestc) " +
                     "VALUES ('Juan', 'Perez', 'Lopez', '2000-01-01', '72345678', 'Peruano', 'Av. Javier Prado 123', '014445555', '999888777', 'juan.perez@unfpg.edu.pe', TRUE, '2026-01-01 10:00:00', 1, 1, 1, 1)");
        jdbc.execute("INSERT INTO metodopago (nommetp, estmetp) VALUES ('Tarjeta', TRUE)");
        jdbc.execute("INSERT INTO rol (nomrol, estrol) VALUES ('Administrador', TRUE)");
    }

    private HttpResponse<String> sendRequest(String method, String path) throws Exception {
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:" + port + path))
            .method(method, HttpRequest.BodyPublishers.noBody())
            .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    @Test
    void testDeshabilitarYHabilitarAlumno() throws Exception {
        // 1. DELETE /api/alumno/1 -> Deshabilitar
        HttpResponse<String> respDelete = sendRequest("DELETE", "/api/alumno/1");
        assertEquals(200, respDelete.statusCode(), "DELETE /api/alumno/1 debe responder 200 OK");
        assertTrue(respDelete.body().contains("\"estalu\":false"), "El estado debe cambiar a false al deshabilitar");

        // 2. PATCH /api/alumno/1 -> Habilitar
        HttpResponse<String> respPatch = sendRequest("PATCH", "/api/alumno/1");
        assertEquals(200, respPatch.statusCode(), "PATCH /api/alumno/1 debe responder 200 OK");
        assertTrue(respPatch.body().contains("\"estalu\":true"), "El estado debe cambiar a true al habilitar");

        // 3. Alternate path: DELETE /api/alumno/1/deshabilitar
        HttpResponse<String> respDeleteAlt = sendRequest("DELETE", "/api/alumno/1/deshabilitar");
        assertEquals(200, respDeleteAlt.statusCode());
        assertTrue(respDeleteAlt.body().contains("\"estalu\":false"));

        // 4. Alternate path: PATCH /api/alumno/1/habilitar
        HttpResponse<String> respPatchAlt = sendRequest("PATCH", "/api/alumno/1/habilitar");
        assertEquals(200, respPatchAlt.statusCode());
        assertTrue(respPatchAlt.body().contains("\"estalu\":true"));

        // 5. Inexistent ID -> 404
        HttpResponse<String> respNotFound = sendRequest("DELETE", "/api/alumno/99999");
        assertEquals(404, respNotFound.statusCode());

        // 6. Invalid ID zero -> 400
        HttpResponse<String> respZero = sendRequest("DELETE", "/api/alumno/0");
        assertEquals(400, respZero.statusCode());

        // 7. Invalid ID text -> 400
        HttpResponse<String> respText = sendRequest("DELETE", "/api/alumno/abc");
        assertEquals(400, respText.statusCode());
    }

    @Test
    void testDeshabilitarYHabilitarMetodoPago() throws Exception {
        HttpResponse<String> respDelete = sendRequest("DELETE", "/api/metodopago/1");
        assertEquals(200, respDelete.statusCode());
        assertTrue(respDelete.body().contains("\"estmetp\":false"));

        HttpResponse<String> respPatch = sendRequest("PATCH", "/api/metodopago/1");
        assertEquals(200, respPatch.statusCode());
        assertTrue(respPatch.body().contains("\"estmetp\":true"));
    }

    @Test
    void testDeshabilitarYHabilitarRol() throws Exception {
        HttpResponse<String> respDelete = sendRequest("DELETE", "/api/rol/1");
        assertEquals(200, respDelete.statusCode());
        assertTrue(respDelete.body().contains("\"estrol\":false"));

        HttpResponse<String> respPatch = sendRequest("PATCH", "/api/rol/1");
        assertEquals(200, respPatch.statusCode());
        assertTrue(respPatch.body().contains("\"estrol\":true"));
    }
}
