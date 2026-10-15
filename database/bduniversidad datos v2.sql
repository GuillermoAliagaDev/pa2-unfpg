-- seleccionamos la base de datos
USE universidad_unfpg;

INSERT INTO estadopago(nomestp, estestp) VALUES
('Pendiente',1),
('Pagado',1),
('Parcial',1),
('Anulado',1);

INSERT INTO metodopago(nommetp, estmetp) VALUES
('Efectivo',1),
('Tarjeta',1),
('Transferencia',1),
('Yape',1),
('Plin',1);

INSERT INTO estadomatricula(nomestm, estestm) VALUES
('Registrada',1),
('Confirmada',1),
('Observada',1),
('Anulada',1);

INSERT INTO tipomatricula(nomtipm, destipm, esttipm) VALUES
('Regular','Matrícula ordinaria dentro del cronograma',1),
('Extemporánea','Matrícula realizada fuera del cronograma regular',1),
('Traslado','Matrícula procedente de otra institución o programa',1),
('Reingreso','Matrícula de estudiante que retoma sus estudios',1);

INSERT INTO rollms(nomroll, estroll) VALUES
('Estudiante',1),
('Docente',1),
('Tutor',1),
('Administrador LMS',1);

INSERT INTO diasemana(nomdias, estdias) VALUES
('Lunes',1),
('Martes',1),
('Miércoles',1),
('Jueves',1),
('Viernes',1),
('Sábado',1),
('Domingo',1);

INSERT INTO rol(nomrol, estrol) VALUES
('Administrador',1),
('Alumno',1),
('Docente',1),
('Secretaría Académica',1),
('Tesorería',1),
('Biblioteca',1),
('Coordinador Académico',1);

INSERT INTO facultad(nomfac, desfac, estfac) VALUES
('Ingeniería y Tecnología','Facultad orientada a ingeniería, computación y tecnologías de información',1),
('Ciencias Empresariales','Facultad orientada a administración, contabilidad y gestión',1),
('Humanidades y Educación','Facultad orientada a educación y ciencias humanas',1);

INSERT INTO categorialibro(nomcatl, estcatl) VALUES
('Programación',1),
('Base de Datos',1),
('Redes',1),
('Ingeniería de Software',1),
('Administración',1),
('Educación',1);

INSERT INTO distrito(nomdis, estdis) VALUES
('Ancón',1),
('Ate',1),
('Barranco',1),
('Breña',1),
('Carabayllo',1),
('Chaclacayo',1),
('Chorrillos',1),
('Cieneguilla',1),
('Comas',1),
('El Agustino',1),
('Independencia',1),
('Jesús María',1),
('La Molina',1),
('La Victoria',1),
('Lima',1),
('Lince',1),
('Los Olivos',1),
('Lurigancho',1),
('Lurín',1),
('Magdalena del Mar',1),
('Miraflores',1),
('Pachacámac',1),
('Pucusana',1),
('Pueblo Libre',1),
('Puente Piedra',1),
('Punta Hermosa',1),
('Punta Negra',1),
('Rímac',1),
('San Bartolo',1),
('San Borja',1),
('San Isidro',1),
('San Juan de Lurigancho',1),
('San Juan de Miraflores',1),
('San Luis',1),
('San Martín de Porres',1),
('San Miguel',1),
('Santa Anita',1),
('Santa María del Mar',1),
('Santa Rosa',1),
('Santiago de Surco',1),
('Surquillo',1),
('Villa El Salvador',1),
('Villa María del Triunfo',1),
('Callao',1),
('Bellavista',1),
('Carmen de La Legua-Reynoso',1),
('La Perla',1),
('La Punta',1),
('Ventanilla',1),
('Mi Perú',1);

INSERT INTO sexo(nomsex, estsex) VALUES
('Masculino',1),
('Femenino',1),
('No Binario',1),
('Otro',1),
('Prefiere no decir',1);

INSERT INTO tipodocumento(nomtipd, esttipd) VALUES
('DNI',1),
('Pasaporte',1),
('Carnet Extranjería',1),
('RUC',1),
('Licencia de Conducir',1);

INSERT INTO areaempleo(nomare, estare) VALUES
('Administración',1),
('Secretaría Académica',1),
('Tesorería',1),
('Biblioteca',1),
('Tecnologías de Información',1),
('Servicios Generales',1);

INSERT INTO cargo(nomcar, estcar) VALUES
('Director Administrativo',1),
('Secretario Académico',1),
('Tesorero',1),
('Bibliotecario',1),
('Analista de Sistemas',1),
('Asistente Administrativo',1);

INSERT INTO tipoaula(nomtipa, esttipa) VALUES
('Aula Teórica',1),
('Laboratorio de Cómputo',1),
('Laboratorio Especializado',1),
('Auditorio',1);

INSERT INTO ubicacion(nomubi, desubi, estubi) VALUES
('Pabellón A - Primer Piso','Área de aulas generales',1),
('Pabellón A - Segundo Piso','Área académica',1),
('Pabellón B - Primer Piso','Laboratorios de cómputo',1),
('Pabellón C','Auditorios y salas especializadas',1);

INSERT INTO periodoacademico(nomper, fecini, fecfin, desper, estper) VALUES
('2026-I','2026-03-16','2026-07-18','Primer período académico 2026',1),
('2026-II','2026-08-17','2026-12-19','Segundo período académico 2026',1);

INSERT INTO bloque(nomblo, iniblo, finblo, estblo) VALUES
('B1','08:00:00','09:30:00',1),
('B2','09:45:00','11:15:00',1),
('B3','11:30:00','13:00:00',1),
('B4','14:00:00','15:30:00',1),
('B5','15:45:00','17:15:00',1),
('B6','18:00:00','19:30:00',1),
('B7','19:45:00','21:15:00',1);

INSERT INTO conceptopago(nomconp, desconp, estconp) VALUES
('Matrícula','Derecho de matrícula académica',1),
('Pensión','Pensión académica mensual',1),
('Certificado','Emisión de certificados',1),
('Carné universitario','Emisión de carné universitario',1);

INSERT INTO estadocivil(nomestc, estestc) VALUES
('Soltero(a)',1),
('Casado(a)',1),
('Viudo(a)',1),
('Divorciado(a)',1);

INSERT INTO gradoinstruccion(nomgrai, estgrai) VALUES
('Bachiller',1),
('Título Profesional',1),
('Maestría',1),
('Doctorado',1);

INSERT INTO estadoaula(nomesta, estesta) VALUES
('Disponible',1),
('Ocupada',1),
('Mantenimiento',1),
('Inhabilitada',1);

INSERT INTO tipocalificacion(nomtipc, esttipc) VALUES
('Práctica Calificada',1),
('Examen Parcial',1),
('Trabajo Académico',1),
('Examen Final',1);

INSERT INTO editorial(nomedi, estedi) VALUES
('Pearson',1),
('McGraw-Hill',1),
('Alfaomega',1),
('Ra-Ma',1),
('Marcombo',1),
('Cengage',1);

INSERT INTO estadoprestamolibro(nomestl, estestl) VALUES
('Prestado',1),
('Devuelto',1),
('Vencido',1),
('Perdido',1);

INSERT INTO aula(nomaul, capaul, codubi, codtipa, codesta) VALUES
('A-101',35,1,1,1),
('A-102',35,1,1,1),
('A-201',40,2,1,1),
('LAB-01',30,3,2,1),
('LAB-02',30,3,2,1),
('LAB-03',25,3,3,1),
('AUD-01',100,4,4,1),
('A-202',40,2,1,1);

INSERT INTO alumno(nomalu, apepalu, apemalu, fecnac, numdoc, nacalu, diralu, telalu, celalu, coralu, estalu, coddis, codsex, codtipd, codestc) VALUES
('Juan Carlos','Ramirez','Lopez','2005-03-15','78000001','Peruana','Av. Los Próceres 123 - San Juan de Lurigancho','014500001','900100001','juan.ramirez@unfpg.edu.pe',1,32,1,1,1),
('Maria Fernanda','Torres','Diaz','2004-07-22','78000002','Peruana','Jr. Las Gardenias 456 - Jesús María','014500002','900100002','maria.torres@unfpg.edu.pe',1,12,2,1,1),
('Luis Alberto','Mendoza','Rios','2003-11-10','78000003','Peruana','Av. Universitaria 789 - Los Olivos','014500003','900100003','luis.mendoza@unfpg.edu.pe',1,17,1,1,1),
('Andrea Valeria','Flores','Soto','2005-01-30','78000004','Peruana','Calle Los Cedros 321 - Ate','014500004','900100004','andrea.flores@unfpg.edu.pe',1,2,2,1,1),
('Pedro Miguel','Castillo','Perez','2004-09-18','78000005','Peruana','Av. Central 555 - Comas','014500005','900100005','pedro.castillo@unfpg.edu.pe',1,9,1,1,1),
('Lucia Daniela','Garcia','Vargas','2006-04-05','78000006','Peruana','Jr. San Martín 222 - Lima','014500006','900100006','lucia.garcia@unfpg.edu.pe',1,15,2,1,1),
('Carlos Eduardo','Sanchez','Morales','2003-12-12','78000007','Peruana','Av. Primavera 888 - Santiago de Surco','014500007','900100007','carlos.sanchez@unfpg.edu.pe',1,40,1,1,1),
('Sofia Camila','Rojas','Fernandez','2005-06-27','78000008','Peruana','Calle Los Pinos 444 - San Miguel','014500008','900100008','sofia.rojas@unfpg.edu.pe',1,36,2,1,1),
('Diego Armando','Vega','Castro','2004-02-14','78000009','Peruana','Av. Grau 999 - La Victoria','014500009','900100009','diego.vega@unfpg.edu.pe',1,14,1,1,1),
('Valentina','Herrera','Campos','2006-08-09','78000010','Peruana','Jr. Los Rosales 101 - Miraflores','014500010','900100010','valentina.herrera@unfpg.edu.pe',1,21,2,1,1);

INSERT INTO docente(nomdoc, apepdoc, apemdoc, fecnac, numdoc, nacdoc, dirdoc, teldoc, celdoc, cordoc, estdoc, suedoc, coddis, codsex, codtipd, codestc) VALUES
('Mario Antonio','Huapalla','Morales','1980-02-10','70000001','Peruana','Av. Universitaria 100','014600001','910200001','mario.huapalla@unfpg.edu.pe',1,4500,15,1,1,2),
('Patricia Elena','Salazar','Ramos','1982-06-18','70000002','Peruana','Av. Arequipa 1200','014600002','910200002','patricia.salazar@unfpg.edu.pe',1,4200,12,2,1,2),
('Jorge Luis','Mendoza','Castro','1978-09-05','70000003','Peruana','Jr. Lima 320','014600003','910200003','jorge.mendoza@unfpg.edu.pe',1,4800,17,1,1,2),
('Claudia Rosa','Fernandez','Vega','1985-01-22','70000004','Peruana','Av. Benavides 450','014600004','910200004','claudia.fernandez@unfpg.edu.pe',1,4100,21,2,1,1),
('Ricardo José','Torres','Flores','1981-11-30','70000005','Peruana','Av. Brasil 800','014600005','910200005','ricardo.torres@unfpg.edu.pe',1,4400,24,1,1,2),
('Ana María','Rojas','Soto','1986-04-14','70000006','Peruana','Calle Central 200','014600006','910200006','ana.rojas@unfpg.edu.pe',1,4000,30,2,1,1);

INSERT INTO docentegrado(coddoc, codgrai, institucion, anioobtencion, nomesp) VALUES
(1,3,'Universidad Nacional Mayor de San Marcos','2015-12-15','Gestión Educativa'),
(1,2,'Universidad Tecnológica del Perú','2008-12-20','Ingeniería de Sistemas'),
(2,3,'Universidad Nacional Federico Villarreal','2016-12-10','Educación Superior'),
(3,4,'Universidad Nacional de Ingeniería','2018-11-20','Ingeniería de Software'),
(4,3,'Universidad de Lima','2017-12-18','Administración'),
(5,3,'Universidad Nacional Mayor de San Marcos','2014-12-12','Redes y Comunicaciones'),
(6,3,'Pontificia Universidad Católica del Perú','2019-12-10','Educación');

INSERT INTO empleado(nomemp, apepemp, apememp, fecnac, numdoc, nacemp, diremp, telemp, celemp, coremp, estemp, sueemp, codare, codcar, coddis, codsex, codtipd, codestc) VALUES
('Roberto','Orue','Bustamante','1975-05-10','72000001','Peruana','Av. Arequipa 1201','014700001','920300001','roberto.orue@unfpg.edu.pe',1,5000,1,1,15,1,1,2),
('Julia','Mendoza','Ramos','1988-08-21','72000002','Peruana','Jr. Central 220','014700002','920300002','julia.mendoza@unfpg.edu.pe',1,2800,2,2,12,2,1,1),
('Carlos','Vargas','León','1984-03-11','72000003','Peruana','Av. Colonial 410','014700003','920300003','carlos.vargas@unfpg.edu.pe',1,3200,3,3,44,1,1,2),
('Rosa','Paredes','Díaz','1990-07-17','72000004','Peruana','Av. La Marina 350','014700004','920300004','rosa.paredes@unfpg.edu.pe',1,2600,4,4,36,2,1,1),
('Miguel','Castro','Reyes','1987-12-02','72000005','Peruana','Av. Universitaria 500','014700005','920300005','miguel.castro@unfpg.edu.pe',1,3800,5,5,17,1,1,2),
('Elena','Flores','Campos','1992-09-14','72000006','Peruana','Jr. Los Olivos 150','014700006','920300006','elena.flores@unfpg.edu.pe',1,2400,1,6,9,2,1,1);

INSERT INTO empleadogrado(codemp, codgrai, institucion, anioobtencion, nomesp) VALUES
(1,3,'Universidad Nacional Federico Villarreal','2012-12-15','Gestión Pública'),
(2,2,'Universidad César Vallejo','2014-12-10','Administración'),
(3,2,'Universidad Nacional del Callao','2010-12-12','Contabilidad'),
(4,1,'Universidad Nacional Mayor de San Marcos','2015-12-18','Bibliotecología'),
(5,2,'Universidad Tecnológica del Perú','2013-12-20','Ingeniería de Sistemas'),
(6,1,'Instituto Superior Tecnológico','2016-12-15','Administración');

INSERT INTO programa(nomprog, estprog, codfac) VALUES
('Ingeniería de Sistemas',1,1),
('Ingeniería de Software',1,1),
('Administración de Empresas',1,2),
('Educación',1,3);

INSERT INTO planestudio(nompla, despla, estpla, codprog) VALUES
('Plan 2026 - Ingeniería de Sistemas','Plan curricular vigente desde 2026',1,1),
('Plan 2026 - Ingeniería de Software','Plan curricular vigente desde 2026',1,2),
('Plan 2026 - Administración','Plan curricular vigente desde 2026',1,3),
('Plan 2026 - Educación','Plan curricular vigente desde 2026',1,4);

INSERT INTO curso(sercur, nomcur, crecur, blocur, codprog) VALUES
('IS101','Fundamentos de Programación',4,4,1),
('IS102','Base de Datos I',4,4,1),
('IS103','Arquitectura de Computadoras',3,3,1),
('IS104','Redes de Computadoras',4,4,1),
('SW101','Ingeniería de Software I',4,4,2),
('SW102','Desarrollo Web',4,4,2),
('AD101','Fundamentos de Administración',3,3,3),
('AD102','Contabilidad General',4,4,3),
('ED101','Fundamentos de Educación',3,3,4),
('ED102','Tecnología Educativa',4,4,4);

INSERT INTO seccion(capsec, codcur, coddoc, codper) VALUES
(30,1,1,1),
(30,2,3,1),
(30,3,5,1),
(30,4,5,1),
(30,5,3,1),
(30,6,1,1),
(35,7,4,1),
(35,8,4,1),
(30,9,6,1),
(30,10,6,1);

INSERT INTO horario(codblo, codsec, coddias, codaul) VALUES
(1,1,1,4),
(2,1,3,4),
(1,2,2,5),
(2,2,4,5),
(3,3,1,1),
(3,4,2,2),
(4,5,3,1),
(4,6,4,4),
(5,7,1,3),
(5,8,2,3),
(6,9,3,8),
(6,10,4,8);

INSERT INTO matricula(obsmat, codalu, codestm, codtipm, codper, estmat) VALUES
('Matrícula regular 2026-I',1,2,1,1,1),
('Matrícula regular 2026-I',2,2,1,1,1),
('Matrícula regular 2026-I',3,2,1,1,1),
('Matrícula regular 2026-I',4,2,1,1,1),
('Matrícula regular 2026-I',5,2,1,1,1),
('Matrícula regular 2026-I',6,2,1,1,1),
('Matrícula regular 2026-I',7,2,1,1,1),
('Matrícula regular 2026-I',8,2,1,1,1),
('Matrícula regular 2026-I',9,2,1,1,1),
('Matrícula regular 2026-I',10,2,1,1,1);

INSERT INTO detallematricula(estdet, nummat, codsec) VALUES
(1,1,1),
(1,1,2),
(1,2,2),
(1,2,3),
(1,3,3),
(1,3,4),
(1,4,4),
(1,4,5),
(1,5,5),
(1,5,6),
(1,6,6),
(1,6,7),
(1,7,7),
(1,7,8),
(1,8,8),
(1,8,9),
(1,9,9),
(1,9,10),
(1,10,10),
(1,10,1);

INSERT INTO calificacion(feccal, nota, coddet, codsec, codtipc) VALUES
('2026-05-11 10:00:00',13,1,1,1),
('2026-06-11 10:00:00',14,1,1,2),
('2026-05-12 10:00:00',14,2,2,1),
('2026-06-12 10:00:00',15,2,2,2),
('2026-05-13 10:00:00',15,3,2,1),
('2026-06-13 10:00:00',16,3,2,2),
('2026-05-14 10:00:00',16,4,3,1),
('2026-06-14 10:00:00',17,4,3,2),
('2026-05-15 10:00:00',17,5,3,1),
('2026-06-15 10:00:00',18,5,3,2),
('2026-05-16 10:00:00',18,6,4,1),
('2026-06-16 10:00:00',19,6,4,2),
('2026-05-17 10:00:00',19,7,4,1),
('2026-06-17 10:00:00',20,7,4,2),
('2026-05-18 10:00:00',12,8,5,1),
('2026-06-18 10:00:00',13,8,5,2),
('2026-05-19 10:00:00',13,9,5,1),
('2026-06-19 10:00:00',14,9,5,2),
('2026-05-10 10:00:00',14,10,6,1),
('2026-06-10 10:00:00',15,10,6,2),
('2026-05-11 10:00:00',15,11,6,1),
('2026-06-11 10:00:00',16,11,6,2),
('2026-05-12 10:00:00',16,12,7,1),
('2026-06-12 10:00:00',17,12,7,2),
('2026-05-13 10:00:00',17,13,7,1),
('2026-06-13 10:00:00',18,13,7,2),
('2026-05-14 10:00:00',18,14,8,1),
('2026-06-14 10:00:00',19,14,8,2),
('2026-05-15 10:00:00',19,15,8,1),
('2026-06-15 10:00:00',20,15,8,2),
('2026-05-16 10:00:00',12,16,9,1),
('2026-06-16 10:00:00',13,16,9,2),
('2026-05-17 10:00:00',13,17,9,1),
('2026-06-17 10:00:00',14,17,9,2),
('2026-05-18 10:00:00',14,18,10,1),
('2026-06-18 10:00:00',15,18,10,2),
('2026-05-19 10:00:00',15,19,10,1),
('2026-06-19 10:00:00',16,19,10,2),
('2026-05-10 10:00:00',16,20,1,1),
('2026-06-10 10:00:00',17,20,1,2);

INSERT INTO asistencia(fecasis, presente, justificada, coddet, codsec) VALUES
('2026-04-06 08:00:00',1,0,1,1),
('2026-04-13 08:00:00',1,0,1,1),
('2026-04-20 08:00:00',1,0,1,1),
('2026-04-06 08:00:00',1,0,2,2),
('2026-04-13 08:00:00',1,0,2,2),
('2026-04-20 08:00:00',1,0,2,2),
('2026-04-06 08:00:00',1,0,3,2),
('2026-04-13 08:00:00',1,0,3,2),
('2026-04-20 08:00:00',1,0,3,2),
('2026-04-06 08:00:00',1,0,4,3),
('2026-04-13 08:00:00',1,0,4,3),
('2026-04-20 08:00:00',1,0,4,3),
('2026-04-06 08:00:00',1,0,5,3),
('2026-04-13 08:00:00',1,0,5,3),
('2026-04-20 08:00:00',1,0,5,3),
('2026-04-06 08:00:00',1,0,6,4),
('2026-04-13 08:00:00',1,0,6,4),
('2026-04-20 08:00:00',1,0,6,4),
('2026-04-06 08:00:00',1,0,7,4),
('2026-04-13 08:00:00',1,0,7,4),
('2026-04-20 08:00:00',0,0,7,4),
('2026-04-06 08:00:00',1,0,8,5),
('2026-04-13 08:00:00',0,1,8,5),
('2026-04-20 08:00:00',1,0,8,5),
('2026-04-06 08:00:00',0,0,9,5),
('2026-04-13 08:00:00',1,0,9,5),
('2026-04-20 08:00:00',1,0,9,5),
('2026-04-06 08:00:00',1,0,10,6),
('2026-04-13 08:00:00',1,0,10,6),
('2026-04-20 08:00:00',1,0,10,6),
('2026-04-06 08:00:00',1,0,11,6),
('2026-04-13 08:00:00',1,0,11,6),
('2026-04-20 08:00:00',1,0,11,6),
('2026-04-06 08:00:00',1,0,12,7),
('2026-04-13 08:00:00',1,0,12,7),
('2026-04-20 08:00:00',1,0,12,7),
('2026-04-06 08:00:00',1,0,13,7),
('2026-04-13 08:00:00',1,0,13,7),
('2026-04-20 08:00:00',1,0,13,7),
('2026-04-06 08:00:00',1,0,14,8),
('2026-04-13 08:00:00',1,0,14,8),
('2026-04-20 08:00:00',1,0,14,8),
('2026-04-06 08:00:00',1,0,15,8),
('2026-04-13 08:00:00',1,0,15,8),
('2026-04-20 08:00:00',1,0,15,8),
('2026-04-06 08:00:00',1,0,16,9),
('2026-04-13 08:00:00',1,0,16,9),
('2026-04-20 08:00:00',0,1,16,9),
('2026-04-06 08:00:00',1,0,17,9),
('2026-04-13 08:00:00',0,0,17,9),
('2026-04-20 08:00:00',1,0,17,9),
('2026-04-06 08:00:00',0,1,18,10),
('2026-04-13 08:00:00',1,0,18,10),
('2026-04-20 08:00:00',1,0,18,10),
('2026-04-06 08:00:00',1,0,19,10),
('2026-04-13 08:00:00',1,0,19,10),
('2026-04-20 08:00:00',1,0,19,10),
('2026-04-06 08:00:00',1,0,20,1),
('2026-04-13 08:00:00',1,0,20,1),
('2026-04-20 08:00:00',1,0,20,1);

INSERT INTO traslado(progori, uniori, esttras, nummat) VALUES
('Ingeniería Informática','Universidad de origen A',1,3),
('Administración','Universidad de origen B',1,8);

INSERT INTO ordenpago(fecordpag, monto, estordpag, nummat, codconp, codmetp, codestp) VALUES
('2026-03-06 09:00:00',350.0,1,1,1,3,2),
('2026-04-06 09:00:00',650.0,1,1,2,3,2),
('2026-03-07 09:00:00',350.0,1,2,1,3,2),
('2026-04-07 09:00:00',650.0,1,2,2,3,2),
('2026-03-08 09:00:00',350.0,1,3,1,3,2),
('2026-04-08 09:00:00',650.0,1,3,2,3,2),
('2026-03-09 09:00:00',350.0,1,4,1,3,2),
('2026-04-09 09:00:00',650.0,1,4,2,3,2),
('2026-03-10 09:00:00',350.0,1,5,1,3,2),
('2026-04-10 09:00:00',650.0,1,5,2,3,2),
('2026-03-11 09:00:00',350.0,1,6,1,3,2),
('2026-04-11 09:00:00',650.0,1,6,2,3,2),
('2026-03-12 09:00:00',350.0,1,7,1,3,2),
('2026-04-12 09:00:00',650.0,1,7,2,3,2),
('2026-03-13 09:00:00',350.0,1,8,1,3,2),
('2026-04-13 09:00:00',650.0,1,8,2,3,2),
('2026-03-14 09:00:00',350.0,1,9,1,3,2),
('2026-04-14 09:00:00',650.0,1,9,2,3,2),
('2026-03-15 09:00:00',350.0,1,10,1,3,2),
('2026-04-15 09:00:00',650.0,1,10,2,3,2);

INSERT INTO pago(fecpag, montopag, estpag, codordpag) VALUES
('2026-03-11 11:00:00',350.0,1,1),
('2026-04-12 11:00:00',650.0,1,2),
('2026-03-13 11:00:00',350.0,1,3),
('2026-04-14 11:00:00',650.0,1,4),
('2026-03-15 11:00:00',350.0,1,5),
('2026-04-16 11:00:00',650.0,1,6),
('2026-03-17 11:00:00',350.0,1,7),
('2026-04-18 11:00:00',650.0,1,8),
('2026-03-19 11:00:00',350.0,1,9),
('2026-04-10 11:00:00',650.0,1,10),
('2026-03-11 11:00:00',350.0,1,11),
('2026-04-12 11:00:00',650.0,1,12),
('2026-03-13 11:00:00',350.0,1,13),
('2026-04-14 11:00:00',650.0,1,14),
('2026-03-15 11:00:00',350.0,1,15),
('2026-04-16 11:00:00',650.0,1,16),
('2026-03-17 11:00:00',350.0,1,17),
('2026-04-18 11:00:00',650.0,1,18),
('2026-03-19 11:00:00',350.0,1,19),
('2026-04-10 11:00:00',650.0,1,20);

INSERT INTO libro(isbnlib, titlib, autlib, deslib, estlib, codcatl, codedi) VALUES
('9780134685991','Effective Java','Joshua Bloch','Buenas prácticas para programación Java',1,1,1),
('9780132350884','Clean Code','Robert C. Martin','Principios para escribir código limpio',1,4,1),
('9786071503145','Fundamentos de Bases de Datos','Silberschatz, Korth y Sudarshan','Conceptos fundamentales de bases de datos',1,2,2),
('9788426728210','SQL','Varios autores','Fundamentos y consultas SQL',1,2,3),
('9780133594140','Computer Networks','Andrew S. Tanenbaum','Fundamentos de redes de computadoras',1,3,1),
('9786071513830','Administración','Stephen Robbins','Fundamentos de administración',1,5,2),
('9788499647351','Ingeniería del Software','Ian Sommerville','Procesos y desarrollo de software',1,4,4),
('9786075224565','Tecnología Educativa','Varios autores','Uso de tecnología aplicada a la educación',1,6,6);

INSERT INTO ejemplarlibro(codlib, codejemplar, estadoeje, esteje) VALUES
(1,'LIB-001-A','DISPONIBLE',1),
(1,'LIB-001-B','DISPONIBLE',1),
(2,'LIB-002-A','DISPONIBLE',1),
(2,'LIB-002-B','DISPONIBLE',1),
(3,'LIB-003-A','DISPONIBLE',1),
(3,'LIB-003-B','DISPONIBLE',1),
(4,'LIB-004-A','DISPONIBLE',1),
(4,'LIB-004-B','DISPONIBLE',1),
(5,'LIB-005-A','DISPONIBLE',1),
(5,'LIB-005-B','DISPONIBLE',1),
(6,'LIB-006-A','DISPONIBLE',1),
(6,'LIB-006-B','DISPONIBLE',1),
(7,'LIB-007-A','DISPONIBLE',1),
(7,'LIB-007-B','DISPONIBLE',1),
(8,'LIB-008-A','DISPONIBLE',1),
(8,'LIB-008-B','DISPONIBLE',1);

INSERT INTO prestamolibro(fecpre, fecdpre, devpre, estpre, codalu, codeje, codestl) VALUES
('2026-04-01','2026-04-08',1,1,1,1,2),
('2026-04-03','2026-04-10',1,1,2,3,2),
('2026-05-01',NULL,0,1,3,5,1),
('2026-05-02',NULL,0,1,4,7,1),
('2026-05-03','2026-05-12',1,1,5,9,2),
('2026-05-05',NULL,0,1,6,11,3);

INSERT INTO cursolms(codpla, estcurl, codsec) VALUES
(1,1,1),
(1,1,2),
(1,1,3),
(1,1,4),
(2,1,5),
(2,1,6),
(3,1,7),
(3,1,8),
(4,1,9),
(4,1,10);

INSERT INTO evaluacionlms(nomeval, deseval, feceval, esteval, codcurl) VALUES
('Evaluación 1','Evaluación virtual correspondiente al curso LMS 1','2026-06-06 18:00:00',1,1),
('Evaluación 2','Evaluación virtual correspondiente al curso LMS 2','2026-06-07 18:00:00',1,2),
('Evaluación 3','Evaluación virtual correspondiente al curso LMS 3','2026-06-08 18:00:00',1,3),
('Evaluación 4','Evaluación virtual correspondiente al curso LMS 4','2026-06-09 18:00:00',1,4),
('Evaluación 5','Evaluación virtual correspondiente al curso LMS 5','2026-06-10 18:00:00',1,5),
('Evaluación 6','Evaluación virtual correspondiente al curso LMS 6','2026-06-11 18:00:00',1,6),
('Evaluación 7','Evaluación virtual correspondiente al curso LMS 7','2026-06-12 18:00:00',1,7),
('Evaluación 8','Evaluación virtual correspondiente al curso LMS 8','2026-06-13 18:00:00',1,8),
('Evaluación 9','Evaluación virtual correspondiente al curso LMS 9','2026-06-14 18:00:00',1,9),
('Evaluación 10','Evaluación virtual correspondiente al curso LMS 10','2026-06-15 18:00:00',1,10);

INSERT INTO matriculalms(fecmatl, estmatl, codalu, codcurl, codroll) VALUES
('2026-03-11 10:00:00',1,1,1,1),
('2026-03-12 10:00:00',1,2,2,1),
('2026-03-13 10:00:00',1,3,3,1),
('2026-03-14 10:00:00',1,4,4,1),
('2026-03-15 10:00:00',1,5,5,1),
('2026-03-16 10:00:00',1,6,6,1),
('2026-03-17 10:00:00',1,7,7,1),
('2026-03-18 10:00:00',1,8,8,1),
('2026-03-19 10:00:00',1,9,9,1),
('2026-03-20 10:00:00',1,10,10,1);

INSERT INTO usuario(nomusu, clausu, corusu, estusu, codalu, coddoc, codemp) VALUES
('alu01','hash_alumno_01','juan.ramirez@unfpg.edu.pe',1,1,NULL,NULL),
('alu02','hash_alumno_02','maria.torres@unfpg.edu.pe',1,2,NULL,NULL),
('alu03','hash_alumno_03','luis.mendoza@unfpg.edu.pe',1,3,NULL,NULL),
('alu04','hash_alumno_04','andrea.flores@unfpg.edu.pe',1,4,NULL,NULL),
('alu05','hash_alumno_05','pedro.castillo@unfpg.edu.pe',1,5,NULL,NULL),
('alu06','hash_alumno_06','lucia.garcia@unfpg.edu.pe',1,6,NULL,NULL),
('alu07','hash_alumno_07','carlos.sanchez@unfpg.edu.pe',1,7,NULL,NULL),
('alu08','hash_alumno_08','sofia.rojas@unfpg.edu.pe',1,8,NULL,NULL),
('alu09','hash_alumno_09','diego.vega@unfpg.edu.pe',1,9,NULL,NULL),
('alu10','hash_alumno_10','valentina.herrera@unfpg.edu.pe',1,10,NULL,NULL),
('doc01','hash_docente_01','mario.huapalla@unfpg.edu.pe',1,NULL,1,NULL),
('doc02','hash_docente_02','patricia.salazar@unfpg.edu.pe',1,NULL,2,NULL),
('doc03','hash_docente_03','jorge.mendoza@unfpg.edu.pe',1,NULL,3,NULL),
('doc04','hash_docente_04','claudia.fernandez@unfpg.edu.pe',1,NULL,4,NULL),
('doc05','hash_docente_05','ricardo.torres@unfpg.edu.pe',1,NULL,5,NULL),
('doc06','hash_docente_06','ana.rojas@unfpg.edu.pe',1,NULL,6,NULL),
('emp01','hash_empleado_01','roberto.orue@unfpg.edu.pe',1,NULL,NULL,1),
('emp02','hash_empleado_02','julia.mendoza@unfpg.edu.pe',1,NULL,NULL,2),
('emp03','hash_empleado_03','carlos.vargas@unfpg.edu.pe',1,NULL,NULL,3),
('emp04','hash_empleado_04','rosa.paredes@unfpg.edu.pe',1,NULL,NULL,4),
('emp05','hash_empleado_05','miguel.castro@unfpg.edu.pe',1,NULL,NULL,5),
('emp06','hash_empleado_06','elena.flores@unfpg.edu.pe',1,NULL,NULL,6);

INSERT INTO usuariorol(codusu, codrol) VALUES
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(9,2),
(10,2),
(11,3),
(12,3),
(13,3),
(14,3),
(15,3),
(16,3),
(17,1),
(18,4),
(19,5),
(20,6),
(21,1),
(22,4);

-- ============================================================
-- CONSULTAS DE VERIFICACION
-- ============================================================
SELECT * FROM estadopago;
SELECT * FROM metodopago;
SELECT * FROM estadomatricula;
SELECT * FROM tipomatricula;
SELECT * FROM rollms;
SELECT * FROM diasemana;
SELECT * FROM rol;
SELECT * FROM facultad;
SELECT * FROM categorialibro;
SELECT * FROM distrito;
SELECT * FROM sexo;
SELECT * FROM tipodocumento;
SELECT * FROM areaempleo;
SELECT * FROM cargo;
SELECT * FROM tipoaula;
SELECT * FROM ubicacion;
SELECT * FROM periodoacademico;
SELECT * FROM bloque;
SELECT * FROM conceptopago;
SELECT * FROM estadocivil;
SELECT * FROM gradoinstruccion;
SELECT * FROM estadoaula;
SELECT * FROM tipocalificacion;
SELECT * FROM editorial;
SELECT * FROM estadoprestamolibro;
SELECT * FROM aula;
SELECT * FROM alumno;
SELECT * FROM docente;
SELECT * FROM docentegrado;
SELECT * FROM empleado;
SELECT * FROM empleadogrado;
SELECT * FROM programa;
SELECT * FROM planestudio;
SELECT * FROM curso;
SELECT * FROM seccion;
SELECT * FROM horario;
SELECT * FROM matricula;
SELECT * FROM detallematricula;
SELECT * FROM calificacion;
SELECT * FROM asistencia;
SELECT * FROM traslado;
SELECT * FROM ordenpago;
SELECT * FROM pago;
SELECT * FROM libro;
SELECT * FROM ejemplarlibro;
SELECT * FROM prestamolibro;
SELECT * FROM cursolms;
SELECT * FROM evaluacionlms;
SELECT * FROM matriculalms;
SELECT * FROM usuario;
SELECT * FROM usuariorol;
