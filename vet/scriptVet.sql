create database veterinaria_web;
-- drop database veterinaria_web;

use veterinaria_web;
-- SELECTS PARA PROBAR
select * from servicios;
select * from Citas;
select * from enfermedades;
select * from especie_enfermedad;
select * from clientes;
select * from roles;

--  MODELO DE INSERTS DE VACUNAS
INSERT INTO vacunas(nombre, fabricante, enfermedad_asociada, edad_recomendada, dosis, precio) VALUES
-- PERROS
('Nobivac Puppy DP', 'MSD Animal Health', 'Parvovirus y Distemper', 1, 1, 45.00),
('Parvovirus','Antirrábica','Lab-Vet',2,2, 45.0),
('Vanguard Plus 5 (Quíntuple)', 'Zoetis', 'Distemper, Adenovirus, Parvovirus, Parainfluenza', 2, 1, 55.00),
('Recombitek C6 (Séptuple)', 'Boehringer Ingelheim', 'Quíntuple + Lepto', 3, 1, 65.00),
('Bronchi-Shield (KC)', 'Zoetis', 'Tos de las Perreras (Bordetella)', 3, 1, 40.00),
('GiardiaVax', 'Zoetis', 'Giardia Lamblia', 4, 2, 50.00),
('Felocell 3 (Triple Felina)', 'Zoetis', 'Rinotraqueitis, Calicivirus, Panleucopenia', 2, 1, 45.00),
('Leucogen', 'Virbac', 'Leucemia Felina', 3, 1, 60.00),
('Nobivac Tricat Trio', 'MSD', 'Calicivirus, Herpesvirus, Panleucopenia', 2, 1, 50.00),
('Rabisin', 'Boehringer Ingelheim', 'Rabia', 4, 1, 35.00);

INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url) VALUES
('Antiparasitarios', 'Protección completa contra pulgas y garrapatas.', 35.00, 100, 'https://www.latiendadefrida.com/cdn/shop/files/1200ftw-104722_1200x1200.jpg?v=1729201367'),
('Alimento Premium', 'Nutrición balanceada adulto raza mediana.', 85.00, 50, 'https://naricitas.pet/wp-content/uploads/2023/07/Canbo-Dog-Balance-Adulto-Razas-Medianas-y-Grandes-de-Pollo-3kg.jpg'),
('Shampoo Medicado', 'Tratamientos dermatológicos piel sensible.', 45.00, 30, 'https://oechsle.vteximg.com.br/arquivos/ids/17503990/imageUrl_1.jpg?v=638506051219770000'),
('Suplementos', 'Vitaminas y probióticos para cachorros.', 55.00, 40, 'https://cloudinary.images-iherb.com/image/upload/f_auto,q_auto:eco/images/srk/srk16803/l/8.jpg'),
('Primeros Auxilios', 'Kit de emergencia veterinaria.', 65.00, 20, 'https://tucanvetfuengirola.com/wp-content/uploads/2024/02/tucan-blog.jpg'),
('Juguetes Dental', 'Juguetes limpieza dental resistente.', 25.00, 150, 'https://cloudinary.images-iherb.com/image/upload/f_auto,q_auto:eco/images/arh/arh96853/y/9.jpg'),
('Collar Reflectivo', 'Collares para paseos nocturnos.', 15.00, 80, 'https://www.superpet.pe/on/demandware.static/-/Sites-SuperPet-master-catalog/default/dw008aa105/images/coastal-collar-reflectivo-3-4-12621-bwg12.jpg'),
('Snacks Saludables', 'Premios nutritivos sabor pollo.', 20.00, 200, 'https://aculi.pe/wp-content/uploads/2021/02/Hills-PD-Acu-li-pet-shop-store-alimento-Snacks-bocaditos-premios-para-Perros-Adultos.jpg'),
('Bravecto 10-20kg', 'Pastilla masticable antipulgas 3 meses.', 120.00, 60, 'https://www.superpet.pe/on/demandware.static/-/Sites-SuperPet-master-catalog/default/dw221fedfd/images/msd-bravecto-500mg-10-20kg.jpg'),
('Nexgard Spectra', 'Antipulgas y desparasitante interno.', 65.00, 80, 'https://mascotify.pe/wp-content/uploads/2020/10/NEXGARD-SPECTRA-30kg-a-60kg-Antipulgas-y-antiparasitario.png'),
('Hills Science Diet', 'Alimento prescripción riñones k/d.', 150.00, 25, 'https://perupets.com/215-large_default/hills-science-diet-adult-large-breed.jpg'),
('Ricocan Cordero', 'Alimento nacional premium 15kg.', 95.00, 40, 'https://promart.vteximg.com.br/arquivos/ids/7299463-1000-1000/image-c8f0958b06eb410dac36165cac3e581f.jpg?v=638249684594670000'),
('Arena para Gatos', 'Aglutinante aroma lavanda 10kg.', 30.00, 100, 'https://oechsle.vteximg.com.br/arquivos/ids/19981432-1000-1000/imageUrl_1.jpg?v=638683291603970000'),
('Rascador Torre', 'Árbol para gatos 3 niveles.', 180.00, 15, 'https://images.unsplash.com/photo-1545249390-6bdfa286032f?w=400'),
('Cama Ortopédica', 'Cama viscoelástica para perros mayores.', 200.00, 10, 'https://rimage.ripley.com.pe/home.ripley/Attachment/MKP/1465/PMP00002101393/full_image-1.jpeg'),
('Pipeta Frontline', 'Antipulgas tópico gatos.', 35.00, 90, 'https://static-shop.vivapets.com/media/catalog/product/cache/11fc96e7318a291175a0004e054be56e/f/r/frontline-dog-tri-act-20-40-kg-1-unity-w-3-pipettes.jpg');


INSERT INTO servicios (nombre, descripcion, icono, precio, estado) VALUES
('Consulta General', 'Chequeo completo de salud.', 'stethoscope', 50.00, 'ACTIVO'),
('Vacunación', 'Aplicación de vacunas anuales.', 'vaccines', 45.00, 'ACTIVO'),
('Profilaxis Dental', 'Limpieza profunda con ultrasonido.', 'dentistry', 120.00, 'ACTIVO'),
('Cirugía Esterilización', 'Castración y Ovariohisterectomía.', 'medical_services', 250.00, 'ACTIVO'),
('Baño y Corte (Grooming)', 'Corte de raza, baño medicado.', 'content_cut', 60.00, 'ACTIVO'),
('Ecografía Abdominal', 'Imágenes de diagnóstico.', 'radiology', 100.00, 'ACTIVO'),
('Rayos X', 'Placas radiográficas digitales.', 'skeleton', 80.00, 'ACTIVO'),
('Análisis de Sangre', 'Hemograma y Bioquímica.', 'science', 70.00, 'ACTIVO'),
('Hospedaje Diario', 'Cuidado por día incluye paseos.', 'home', 40.00, 'ACTIVO');

INSERT INTO especies (nombre) VALUES
('Felina'),
('Canina');

INSERT INTO enfermedades (descripcion, gravedad, nombre) values 
('Enfermedad viral grave que afecta intestinos','Alta','Parvovirus'),
('Afecta sistemas respiratorios, gastrointestinal y nervioso','Alta','Distemper (Moquillo)'),
('Inflamación del conducto auditivo','Baja','Otitis Externa'),
('Enfermedad viral que afecta el sistema inmune','Alta','Leucemia Felina'),
('Infeccion bacteriana transmitida por garrapatas, causa anemia','Media','Ehrlichia (Garrapata)'),
('Ácaros que causan picazón intensa y pérdidad de pelo','Media','Sarna Sarcópita'),
('Fallo en la funcion de los riñones','Alta','Insuficiencia Renal'),
('Virus mortal que afecta el sistema nervioso central','Alta','Rabia');

INSERT INTO especie_enfermedad (enfermedad_id, especie_id) VALUES
(1,2),
(2,2),
(3,1),
(3,2),
(4,1),
(5,2),
(6,1),
(6,2),
(7,1),
(8,1),
(8,2);

INSERT INTO roles (nombre) VALUES 
('ROLE_ADMIN'),
('ROLE_USER'),
('ROLE_VET');

INSERT INTO trabajadores (apellidos, nombres, correo, cargo, dni, telefono, estado) VALUES 
('ZUMAETA GOLAC','JUNIOR FERNANDO' ,'jufer@vethuellitas.com','VETERINARIO','71374454','987654321','ACTIVO'),
('RAMIREZ LOPEZ','CARLA ANDREA','carla@vethuellitas.com','VETERINARIO','74561234','912345678','ACTIVO'),
('TORRES VASQUEZ','LUIS MIGUEL','luis@vethuellitas.com','VETERINARIO','75678901','923456789','ACTIVO'),
('MENDOZA FLORES','RICARDO DANIEL','ricardo@vethuellitas.com','VETERINARIO','79012345','967890123','ACTIVO'),
('GARCIA CHAVEZ','PAOLA ESTEFANIA','paola@vethuellitas.com','VETERINARIO','70123456','978901234','ACTIVO'),
('ORTIZ CAMPOS','MARTIN EDUARDO','martin@vethuellitas.com','VETERINARIO','73456789','901234567','ACTIVO'),
('CASTILLO RUIZ','MARIA FERNANDA','maria@vethuellitas.com','RECEPCIONISTA','76789012','934567890','ACTIVO'),
('RODRIGUEZ PEREZ','ELENA SOFIA','elena@vethuellitas.com','ESTILISTA','78901234','956789012','ACTIVO'),
('VARGAS QUISPE','DIEGO ARMANDO','diego@vethuellitas.com','ESTILISTA','71234567','989012345','ACTIVO'),
('HUAMAN CRUZ', 'DENNIS FABRIZIO','fabrizio@vethuellitas.com','CIRUJANO','73381545','920625158','ACTIVO'),
('SANCHEZ DIAZ','JORGE ALBERTO','jorge@vethuellitas.com','CIRUJANO','77890123','945678901','ACTIVO'),
('RIVERA SALAZAR','ANA LUCIA','ana@vethuellitas.com','CIRUJANO','72345678','990123456','ACTIVO');

INSERT INTO usuarios (username, password, trabajador_id, estado) VALUES
('jufer','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',1,'ACTIVO'), -- trabajador
('dennis','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',2,'ACTIVO'), -- trabajador
('chriso','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',NULL,'ACTIVO'), -- NULL PORQUE ES ADMIN
('carla','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',3,'ACTIVO'),
('luis','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',4,'ACTIVO'),
('maria','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',5,'ACTIVO'),
('jorge','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',6,'ACTIVO'),
('elena','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',7,'ACTIVO'),
('ricardo','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',8,'ACTIVO'),
('paola','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',9,'ACTIVO'),
('diego','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',10,'ACTIVO'),
('ana','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',11,'ACTIVO'),
('martin','$2a$12$fIpHfhGambfFnIAXfn/sQuxP1LKWjttL9YKmaFO5QdETmyFg2qOCm',12,'ACTIVO');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES 
(1,3), 
(2,3), 
(3,1),
(4,3),
(5,3),
(6,3),
(7,3),
(8,3),
(9,3),
(10,3),
(11,3),
(12,3);

-- INSERT INTO CLIENTES
INSERT INTO clientes (apellidos, correo, direccion, dni, nombres, telefono, usuario_id) values
('HUAMAN CRUZ','dennis@prueba.com','Incanato 1128',73381544,'DENNIS FABRIZIO','920625158',NULL),
('VASQUEZ CARRASCO','emmy@emmy.com','Las Delicias',76296919,'ESMERALDA MARIA ROSINA','980228236',NULL),
('PEREZ SOSA', 'perez.sosa@email.com', 'Calle Los Jazmines 450', '45871236', 'RICARDO ALBERTO', '987456123', NULL),
('LOPEZ VILLEGAS', 'ana.lopez@email.com', 'Av. Santa Victoria 782', '71258963', 'ANA BEATRIZ', '951753852', NULL),
('TORRES MENDOZA', 'mendoza.t@email.com', 'Urb. Las Garzas B-12', '10258744', 'LUIS ENRIQUE', '963258741', NULL),
('CASTILLO DIAZ', 'c.diaz@email.com', 'Calle San Jose 115', '44859632', 'MARIA FERNANDA', '941258369', NULL),
('SANCHEZ RUIZ', 'sanchez.r@email.com', 'Av. Jose Leonardo Ortiz 900', '72154863', 'CARLOS JAVIER', '932145687', NULL),
('MORALES PAZ', 'mpaz@email.com', 'Calle Elvira Garcia 221', '09856321', 'GLADYS NOEMI', '914785236', NULL),
('CAMPOS YOVERA', 'campos.y@email.com', 'Calle Tacna 556', '73365412', 'JOSE MIGUEL', '955441122', NULL),
('DURAND SILVA', 'durand.s@email.com', 'Residencial La Ensenada', '46985214', 'PATRICIA ROSA', '988774411', NULL);

-- INSERT INTO DE MASCOTAS
INSERT INTO mascotas (edad, especie, nombre, observaciones, peso, raza, sexo, cliente_id) VALUES 
('4 años', 'Felina', 'Olenka', 'Sin observaciones médicas', 23.5, 'Naranjoso', 'Hembra', 1),
('2 años', 'Felina', 'Apolo', 'Sin observaciones médicas', 23.5, 'Naranjoso', 'Macho', 1), 
('2 años', 'Canina', 'Peluche', 'Sin observaciones médicas', 23.5, 'Shih Tzu', 'Macho', 2),
('3 años', 'Canina', 'Harry', 'Sin observaciones médicas', 23.5, 'Shih Tzu', 'Macho', 2),
('5 años', 'Canina', 'Rambo', 'Alérgico al polen', 25.4, 'Boxer', 'Macho', 3),
('3 años', 'Felina', 'Misi', 'Castrada recientemente', 3.8, 'Siamés', 'Hembra', 4),
('2 meses', 'Felina', 'Pelusa', 'Cachorro sin vacunas', 0.9, 'Mestizo', 'Hembra', 4),
('7 años', 'Canina', 'Bruno', 'Problemas de cadera', 30.2, 'Pastor Alemán', 'Macho', 5),
('1 año', 'Canina', 'Chispita', 'Muy juguetona', 5.1, 'Poodle', 'Hembra', 6),
('4 años', 'Canina', 'Zeus', 'Requiere limpieza dental', 18.5, 'Bulldog Inglés', 'Macho', 7), 
('6 años', 'Felina', 'Garfield', 'Sobrepeso leve', 7.2, 'Persa', 'Macho', 8),
('2 años', 'Canina', 'Rex', 'Sin observaciones', 15.0, 'Schnauzer', 'Macho', 9), 
('8 años', 'Canina', 'Pelusa', 'Soplo al corazón leve', 10.4, 'Cocker Spaniel', 'Hembra', 10);

-- VETERINARIOS (id 1-6) → Consulta, Vacunación, Profilaxis, Ecografía, Rayos X, Análisis de Sangre
INSERT INTO trabajador_servicio (trabajador_id, servicio_id) VALUES
(1,1),(1,2),(1,3),(1,6),(1,7),(1,8),
(2,1),(2,2),(2,3),(2,6),(2,7),(2,8),
(3,1),(3,2),(3,3),(3,6),(3,7),(3,8),
(4,1),(4,2),(4,3),(4,6),(4,7),(4,8),
(5,1),(5,2),(5,3),(5,6),(5,7),(5,8),
(6,1),(6,2),(6,3),(6,6),(6,7),(6,8),
-- CIRUJANOS (id 10-12) → Cirugía Esterilización + servicios veterinarios
(10,1),(10,2),(10,4),(10,6),(10,7),(10,8),
(11,1),(11,2),(11,4),(11,6),(11,7),(11,8),
(12,1),(12,2),(12,4),(12,6),(12,7),(12,8),
-- ESTILISTAS (id 8-9) → solo Grooming
(8,5),
(9,5),
-- RECEPCIONISTA (id 7) → Hospedaje
(7,9);

INSERT INTO citas (estado, fecha_hora, motivo, servicio_id, mascota_id, trabajador_id) VALUES
-- REALIZADAS (historial)
('REALIZADA', '2026-01-05 09:00:00', 'Chequeo anual rutinario',        1,  1,  1),
('REALIZADA', '2026-01-08 10:30:00', 'Vacuna antirrábica anual',        2,  3,  2),
('REALIZADA', '2026-01-12 11:00:00', 'Limpieza dental profunda',        3,  10, 3),
('REALIZADA', '2026-01-15 09:30:00', 'Análisis de sangre preventivo',   8,  8,  4),
('REALIZADA', '2026-01-20 14:00:00', 'Corte de raza completo',          5,  3,  9),
('REALIZADA', '2026-01-22 15:00:00', 'Ecografía abdominal control',     6,  11, 5),
('REALIZADA', '2026-01-28 08:30:00', 'Rayos X cadera',                  7,  8,  6),
('REALIZADA', '2026-02-03 10:00:00', 'Castración programada',           4,  4,  10),
('REALIZADA', '2026-02-05 11:30:00', 'Vacunación completa cachorro',    2,  7,  1),
('REALIZADA', '2026-02-10 09:00:00', 'Consulta por alergia al polen',   1,  5,  2),
('REALIZADA', '2026-02-14 14:30:00', 'Baño medicado piel sensible',     5,  12, 8),
('REALIZADA', '2026-02-18 10:00:00', 'Ovariohisterectomía',             4,  6,  11),
('REALIZADA', '2026-02-25 09:30:00', 'Hemograma completo',              8,  11, 3),
('REALIZADA', '2026-03-01 11:00:00', 'Profilaxis dental',               3,  2,  4),
('REALIZADA', '2026-03-04 08:00:00', 'Rayos X tórax control',           7,  13, 5),
('REALIZADA', '2026-03-07 10:30:00', 'Consulta soplo cardíaco',         1,  13, 6),
('REALIZADA', '2026-03-10 14:00:00', 'Corte de verano',                 5,  3,  9),
('REALIZADA', '2026-03-11 09:00:00', 'Ecografía abdominal',             6,  5,  1),
-- CONFIRMADAS (próximas)
('CONFIRMADA', '2026-03-14 09:00:00', 'Control post operatorio',        1,  6,  2),
('CONFIRMADA', '2026-03-14 10:30:00', 'Vacuna quíntuple refuerzo',      2,  9,  3),
('CONFIRMADA', '2026-03-15 09:00:00', 'Baño y corte raza',              5,  4,  8),
('CONFIRMADA', '2026-03-15 11:00:00', 'Análisis bioquímica',            8,  8,  4),
('CONFIRMADA', '2026-03-16 10:00:00', 'Cirugía programada',             4,  12, 12),
('CONFIRMADA', '2026-03-17 09:30:00', 'Limpieza dental',                3,  10, 5),
('CONFIRMADA', '2026-03-18 14:00:00', 'Ecografía control',              6,  1,  6),
('CONFIRMADA', '2026-03-19 10:00:00', 'Rayos X columna',                7,  8,  1),
-- PENDIENTES (agendadas sin confirmar)
('PENDIENTE', '2026-03-20 09:00:00', 'Chequeo general',                 1,  2,  2),
('PENDIENTE', '2026-03-20 11:00:00', 'Vacunación inicial',              2,  7,  3),
('PENDIENTE', '2026-03-21 10:00:00', 'Baño medicado',                   5,  5,  9),
('PENDIENTE', '2026-03-22 09:30:00', 'Hemograma preventivo',            8,  13, 4),
('PENDIENTE', '2026-03-24 14:00:00', 'Consulta primera vez',            1,  9,  1),
('PENDIENTE', '2026-03-25 10:30:00', 'Profilaxis dental programada',    3,  7,  5),
('PENDIENTE', '2026-03-26 09:00:00', 'Ecografía abdominal',             6,  12, 6),
('PENDIENTE', '2026-03-28 11:00:00', 'Corte primavera',                 5,  4,  8),
-- CANCELADAS
('CANCELADA', '2026-02-20 09:00:00', 'Cliente no se presentó',          1,  1,  1),
('CANCELADA', '2026-02-22 10:00:00', 'Reagendada por el cliente',       2,  3,  2),
('CANCELADA', '2026-03-01 14:00:00', 'Mascota enferma al momento',      5,  9,  9),
('CANCELADA', '2026-03-05 09:30:00', 'Cancelado por emergencia',        4,  6,  11);


