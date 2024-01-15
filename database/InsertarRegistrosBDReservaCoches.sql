INSERT INTO Garajes (gaNombre, gaDireccion) VALUES
('García Barbón, 2', 'Vigo'),
('Gran Via 4', 'Bilbao'),
('Easo, 5', 'San Sebastian'),
('Serrano, 23', 'Madrid'),
('Diagonal, 111', 'Barcelona');

INSERT INTO Clientes (clNif, clNombre, clDireccion, clTelefono) VALUES 
('12131414P', 'Luis Garcia Anton', 'America, 56, VIGO', 663522484),
('21022584A', 'Alvaro Rodriguez', 'Principe, 24, VIGO', 654123654),
('47852103Z', 'Jaime Llorens', 'Puerto, 18, Bilbao',   658666654),
('22365105L', 'Antonio Canales', 'Venezuela, 10, VIGO', 666123878),
('35852106M', 'Juan Suarez', 'Caracas, 15, Madrid',  638541858),
('47892107Q', 'Julian Lopez', 'Monaco, 1, Barcelona', 639753357),
('54322108U', 'Julia Antequera', 'Paris, 128, Cangas',  659147852),
('67892109J', 'Alberto Juanes', 'Vigo, 19, Nigran', 658369852),
('21456711G', 'Cristobal Garcia', 'Argentina, 19, San Sebastian',  633265148),
('32416172T', 'Maria Silva', 'Mexico, 15, VIGO',  624722793),
('25161738Y', 'Luisa Maron', 'Uruguay, 30, Madrid',  623147852),
('42516714R', 'Cristina Bulini', 'Colombia, 24, Barcelona', 641256389),
('21891995H', 'Vicente Martinez', 'Jardines, 17, Eibar',  656784512),
('34215617T', 'Carlos Tena', 'Markiegui, 10, Deba',  656784555);


INSERT INTO Coches (coMatricula, coMarca, coModelo, 
coColor,  coPrecio, coDisponible, coGaraje) VALUES
('JKF-1456', 'Citroën', 'C-Zero','Rojo',  18, true, 1),
('JKF-1457', 'Citroën', 'e-Mehari', 'Blanco', 18, true, 2), 
('JKF-1458', 'Citroën', 'Nuevo C1', 'Azul marino',  18, true, 3),
('JKF-1459', 'Citroën', 'Nuevo Citroën C3', 'Azul metalizado',  18, true, 4),
('JKF-1460', 'Citroën', 'C4', 'Amarillo', 18, true, 5),
('JBB-5621', 'Fiat', '124 Spider', 'Verde',  18, true, 1), 
('JBB-5622', 'Fiat', 'Bravo', 'Negro',  18, true, 2), 
('JBB-5623', 'Fiat', '500', 'Gris metalizado',  18, true, 3), 
('JBB-5624', 'Fiat', '500X', 'Azul marino',  18, true, 4),
('JBB-5625', 'Fiat', 'Punto', 'Azul metalizado', 18,  true, 5), 
('HHL-9874', 'Alfa Romeo', 'MiTo','Blanco',  20,  true, 1),
('HHL-9875', 'Alfa Romeo', 'Giulietta', 'Verde',  20, true, 2),
('HHL-9876', 'Alfa Romeo', 'Stelvio', 'Gris metalizado',  20,  true, 3),
('HHL-9877', 'Alfa Romeo', 'MiTo', 'Rojo',  20,  true, 4),
('HHL-9878', 'Alfa Romeo', 'Giulietta', 'Gris metalizado', 20, true, 5),
('JLJ-1546', 'Audi', 'Q3', 'Azul marino', 20,  true, 1),
('JLJ-1547', 'Audi', 'A3', 'Azul metalizado', 20,  true, 2),
('JLJ-1548', 'Audi', 'A3', 'Gris metalizado',  20,  true, 3),
('JLJ-1549', 'Audi', 'A4', 'Verde',  20,  true, 4),
('JLJ-1550', 'Audi', 'A4', 'Rojo',  20, true, 5),
('JFD-8456', 'Lancia', 'Ypsilon', 'Azul marino',  18, true, 1),
('JFD-8457', 'Lancia', 'Ypsilon', 'Azul metalizado',  18, true, 2),
('JFD-8458', 'Lancia', 'Ypsilon', 'Gris metalizado',  18, true, 3),
('JFD-8459', 'Lancia', 'Musa', 'Verde', 25,  true, 4),
('JFD-8460', 'Lancia', 'Delta', 'Verde', 25, true, 5),
('HPM-6541', 'Subaru', 'XV', 'Rojo', 25, true, 1),
('HPM-6542', 'Subaru', 'LEVORG', 'Gris metalizado', 25, true, 2),
('HPM-6543', 'Subaru', 'OUTBACK', 'Azul marino', 25, true, 3),
('HPM-6544', 'Subaru', 'XV', 'Azul metalizado', 25, true, 3),
('HPM-6545', 'Subaru', 'OUTBACK', 'Verde', 25, true, 4),
('JKK-3521', 'Renault', 'Clio', 'Verde', 25, true, 5),
('JKK-3522', 'Renault', 'Clio', 'Rojo', 25, true, 1),
('JKK-3523', 'Renault', 'Space', 'Azul marino', 25, true, 2),
('JKK-3524', 'Renault', 'Space', 'Gris metalizado', 25, true, 3),
('JKK-3525', 'Renault', 'Grand Scénic', 'Verde', 25, true, 3),
('JBC-9541', 'Skoda', 'Citigo', 'Azul metalizado', 18, true, 1),
('JBC-9542', 'Skoda', 'Citigo','Verde', 18, true, 2),
('JBC-9543', 'Skoda', 'Citigo Monte Carlo','D', 18, true, 4),
('JBC-9544', 'Skoda', 'Fabia', 'Rojo', 18, true, 5),
('JBC-9545', 'Skoda', 'Fabia Like','Verde', 18, true, 4),
('JMN-6543', 'Mazda', 'Mazda 2', 'Gris metalizado', 25, true, 5),
('JMN-6544', 'Mazda', 'Mazda 2', 'Azul marino', 25, true, 3),
('JMN-6545', 'Mazda', 'Mazda 3','Azul metalizado', 25, true, 4),
('JMN-6546', 'Mazda', 'CX-3', 'Verde', 25, true, 4),
('JMN-6547', 'Mazda', 'CX-3', 'Gris metalizado',25,  true, 2),
('JGG-8888', 'Volkswagen', 'Golf GTI', 'Verde',25, true, 2),
('JGG-8889', 'Volkswagen', 'Golf GTI', 'Rojo',25, true, 5),
('JGG-8890', 'Volkswagen', 'Touran', 'Gris metalizado',25, true, 2),
('JGG-8891', 'Volkswagen', 'Touran', 'Azul marino', 25,  true, 1),
('JGG-8892', 'Volkswagen', 'Touran', 'Verde', 25,  true, 3),
('JBC-8745', 'BMW', 'Berlina', 'Rojo', 30, true, 3),
('JBC-8746', 'BMW', 'Touring', 'Azul metalizado', 30, true, 4),
('JBC-8747', 'BMW', 'Familiar', 'Azul marino', 30, true, 4),
('JBC-8748', 'BMW', 'Berlina', 'Rojo', 30, true, 5),
('JBC-8749', 'BMW', 'Touring', 'Gris metalizado', 30, true, 1),
('JCC-7841', 'LAND-ROVER', 'Discovery Sport', 'Rojo', 30, true, 2),
('JCC-7842', 'LAND-ROVER', 'Discovery Sport', 'Azul metalizado', 30, true, 3),
('JCC-7843', 'LAND-ROVER', 'Discovery Sport','Azul marino', 30, true, 4),
('JCC-7844', 'LAND-ROVER', 'Range Rover Evoque','Rojo', 30, true, 5),
('JCC-7845', 'LAND-ROVER', 'Range Rover Evoque','Gris metalizado', 30, true, 1),
('HHM-4569', 'JAGUAR', 'Berlina', 'Verde', 30, true, 2), 
('HHM-4570', 'JAGUAR', 'E-Pace', 'Blanco', 30, true, 3), 
('HHM-4571', 'JAGUAR', 'F-Pace', 'Rojo', 30, true, 4), 
('HHM-4572', 'JAGUAR', 'F-Type','Gris metalizado', 30, true, 5),
('HHM-4573', 'JAGUAR', 'Eléctrico', 'Granate', 30, true, 1),
('HLM-9898', 'Mercedes-Benz', 'Clase A Berlina', 'Azul marino', 30, true, 2),  
('HLM-9899', 'Mercedes-Benz', 'Clase A Berlina', 'Azul metalizado', 30,  true, 3), 
('HLM-9900', 'Mercedes-Benz', 'Clase C Estate', 'Rojo', 30,  true, 4), 
('HLM-9901', 'Mercedes-Benz', 'GLC TodoTerreno', 'Gris metalizado', 30,  true, 5), 
('HLM-9902', 'Mercedes-Benz', 'GLA TodoTerreno', 'Azul marino', 30,  true, 1);


INSERT INTO Reservas (reCodigo, reFecInicio, reFecFinal) VALUES
(1, '2019-01-04', date_add(reFecInicio, INTERVAL 4 DAY)), 
(2, '2019-04-15', date_add(reFecInicio, INTERVAL 5 DAY)), 
(3, '2019-02-15', date_add(reFecInicio, INTERVAL 8 DAY)),
(4, '2019-04-15', date_add(reFecInicio, INTERVAL 6 DAY)),
(5, '2019-05-10', date_add(reFecInicio, INTERVAL 4 DAY)), 
(6, '2019-06-10', date_add(reFecInicio, INTERVAL 7 DAY)), 
(7, '2019-11-12', date_add(reFecInicio, INTERVAL 3 DAY)),
(8, '2019-11-10', date_add(reFecInicio, INTERVAL 2 DAY)),
(9, '2019-11-08', date_add(reFecInicio, INTERVAL 1 DAY)),
(10, '2019-11-25', date_add(reFecInicio, INTERVAL 5 DAY)),
(11, '2019-11-05', date_add(reFecInicio, INTERVAL 3 DAY) ),
(12, '2019-04-02', date_add(reFecInicio, INTERVAL 2 DAY)),
(13, '2019-11-10', date_add(reFecInicio, INTERVAL 6 DAY)),
(14, '2019-11-27', date_add(reFecInicio, INTERVAL 8 DAY)),
(15, '2019-10-12', date_add(reFecInicio, INTERVAL 10 DAY)),
(16, '2019-11-01', date_add(reFecInicio, INTERVAL 1 DAY)),
(17, '2019-04-10', date_add(reFecInicio, INTERVAL 2 DAY));




INSERT INTO INVOLUCRA (inMatricula, inCliente, inReserva,
inLitros) VALUES
('JBB-5623', '47892107Q', 1, 60), 
('JBB-5623', '47892107Q', 2, 80), 
('JBB-5624', '12131414P', 3, 25),
('JBB-5624', '12131414P', 4, 38),
('JBB-5625', '21891995H', 5, 48), 
('JBB-5625', '21891995H', 6, 32), 
('JBC-9541', '21891995H', 7, 64),
('JBC-9541', '21891995H', 8, 25),
('JBC-9542', '67892109J', 9, 80),
('JBC-9544', '21022584A', 10, 25),
('JBC-9544', '22365105L', 11, 32 ),
('JBC-9544', '22365105L', 12, 29),
('JBC-9545', '21891995H', 13, 49),
('JBC-9545', '21891995H', 14, 66),
('JBC-8745', '21891995H', 15, 58),
('JBC-8746', '12131414P', 16, 78),
('JBC-8749', '54322108U', 17, 54);

select * from Reservas where month(reFecInicio)=4;
