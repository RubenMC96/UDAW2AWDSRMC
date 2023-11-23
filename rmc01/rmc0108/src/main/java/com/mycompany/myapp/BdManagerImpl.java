package com.mycompany.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BdManagerImpl implements BdManager {

    private final String URL = "jdbc:sqlite:archivos/empleados.db";

    public int vaciarTabla() throws SQLException {
        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM empleados");
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;
    }

    public int cargaInicial(ArrayList<Empleado> empleados) throws SQLException {

        ArrayList <Empleado> empleadosPrev = new ArrayList<>();
        empleadosPrev = FileManager.leerFichero();

        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:archivos/empleados.db")) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO empleados empleadosPrev VALUES ?");
            ps.setObject(1, empleadosPrev);
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;

    }

    public ArrayList<Empleado> consultar() throws SQLException {

         ArrayList <Empleado> todosEmpleados = new ArrayList<>();
         for(Empleado empleado : todosEmpleados){

            todosEmpleados.remove(empleado);

         };

        String sql = "SELECT id, nombre, salario FROM empleados";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db");
        
            PreparedStatement ps = conexion.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    todosEmpleados.add(new Empleado(rs.getLong(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e) {
        System.out.println("Código de Error: " + e.getErrorCode() + "%n" +
        "SLQState: " + e.getSQLState() + "%n" +
        "Mensaje: " + e.getMessage() + "%n");
        }
        
        return todosEmpleados;

    }

    public ArrayList<Empleado> consultar(double minSalar, double maxSalar) throws SQLException {

        ArrayList <Empleado> empleadoSaslarioMinMax = new ArrayList<>();
        double salarioMin = minSalar;
        double salarioMax = maxSalar;
        for(Empleado empleado : empleadoSaslarioMinMax){

            empleadoSaslarioMinMax.remove(empleado);

         };

        String sql = "SELECT id, nombre, salario FROM empleados WHERE salario BETWEEN ? AND ?";
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:empleados.db");
            PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setDouble(1, salarioMin);
                ps.setDouble(2, salarioMax);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    empleadoSaslarioMinMax.add(new Empleado(rs.getLong(1), rs.getString(2), rs.getDouble(3)));
            }
        } catch (SQLException e) {
        System.out.println("Código de Error: " + e.getErrorCode() + "%n" +
        "SLQState: " + e.getSQLState() + "%n" +
        "Mensaje: " + e.getMessage() + "%n");
        }
        
        return empleadoSaslarioMinMax;
    }

    public int insertar(Empleado empleado) throws SQLException {

        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO empleados (id, nombre, salario) VALUES (?, ?, ?)");
            ps.setLong(1, empleado.id);
            ps.setString(2, empleado.nombre);
            ps.setDouble(3, empleado.salario);
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;

    }

    public int borrar(Long id) throws SQLException {

        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM empleados WHERE id = ?");
            ps.setLong(1, id);
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;
    }

    public int actualizar(Empleado empleado) throws SQLException {
        
        int cantFilas = 0;
        try (Connection connection = DriverManager.getConnection(URL)) {
            PreparedStatement ps = connection.prepareStatement("UPDATE empleados SET nombre = ?, salario = ?  WHERE id = ?");
            ps.setLong(1, empleado.id);
            ps.setString(2, empleado.nombre);
            ps.setDouble(3, empleado.salario);
            cantFilas = ps.executeUpdate();
            ps.close();
        }
        return cantFilas;

    }
}
