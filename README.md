# perfulandia
Proyecto semestral realizado en springboot

-------------------------------------------------------------------------------------------

Poblado de tablas de clientes

USE perfulandia;

INSERT INTO clientes (nombre, apellido, rut, correo, telefono) VALUES
('Juan', 'Pérez', '12.345.678-9', 'juan.perez@example.com', '+56912345678'),
('Ana', 'Gómez', '11.222.333-4', 'ana.gomez@example.com', '+56987654321'),
('Carlos', 'Soto', '15.555.555-5', 'carlos.soto@example.com', '+56911223344'),
('María', 'López', '18.999.999-6', 'maria.lopez@example.com', '+56922334455'),
('Pedro', 'Muñoz', '17.888.888-7', 'pedro.munoz@example.com', '+56933445566'),
('Sofía', 'Ramírez', '14.444.444-8', 'sofia.ramirez@example.com', '+56944556677'),
('Diego', 'Herrera', '13.333.333-2', 'diego.herrera@example.com', '+56955667788'),
('Camila', 'Rojas', '19.111.111-1', 'camila.rojas@example.com', '+56966778899'),
('Felipe', 'Navarro', '16.666.666-3', 'felipe.navarro@example.com', '+56977889900'),
('Valentina', 'Fuentes', '10.101.010-0', 'valentina.fuentes@example.com', '+56988990011');

-------------------------------------------------------------------------------------------

Poblado de tablas de Ventas

INSERT INTO ventas (nombre_producto, cantidad, precio, total, fecha_venta) VALUES
('Perfume Carolina Herrera', 3, 45000, 135000, NOW()),
('Perfume Dior Sauvage', 2, 60000, 120000, NOW()),
('Perfume Jean Paul Gaultier', 1, 75000, 75000, NOW()),
('Perfume Paco Rabanne One Million', 4, 52000, 208000, NOW()),
('Perfume Versace Eros', 2, 68000, 136000, NOW());


-------------------------------------------------------------------------------------------


Poblado de tablas de Producto 

INSERT INTO productos (nombre, descripcion) VALUES
('Hugo Boss Bottled', 'Perfume Hugo Boss Bottled 100ml'),
('Calvin Klein Eternity', 'Perfume Calvin Klein Eternity 200ml'),
('Dior Sauvage', 'Perfume Dior Sauvage 100ml'),
('Carolina Herrera Good Girl', 'Perfume Carolina Herrera Good Girl 80ml'),
('Versace Eros', 'Perfume Versace Eros 100ml');


---------------------------------------------------------------------------------------------





