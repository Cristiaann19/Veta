create database veterinaria_web;
-- drop database veterinaria_web;

use veterinaria_web;
select * from VACUNAS;


--  MODELO DE INSERTS DE VACUNAS
INSERT INTO vacunas (dosis,edad_recomendada,enfermedad_asociada,nombre, fabricante, precio) 
VALUES (2,2,'Parvovirus','Antirrábica', 'Lab-Vet', 45.0);
INSERT INTO vacunas(nombre, fabricante, enfermedad_asociada, edad_recomendada, dosis, precio) VALUES
-- PERROS
('Nobivac Puppy DP', 'MSD Animal Health', 'Parvovirus y Distemper', 1, 1, 45.00),
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

