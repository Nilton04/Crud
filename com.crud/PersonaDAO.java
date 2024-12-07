
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    public void agregarPersona(Persona persona) {
        String query = "INSERT INTO persona (nombre, apellido, edad) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConexion();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar persona: " + e.getMessage());
            //e.printStackTrace();
        }
    }

    public List<Persona> obtenerPersonas() {
        List<Persona> personas = new ArrayList<>();
        String query = "SELECT * FROM persona";
        try (Connection conn = DBConnection.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Persona persona = new Persona(
                    rs.getString("nombre"), 
                    rs.getString("apellido"), 
                    rs.getInt("edad")
                );
                persona.setId(rs.getInt("id"));
                personas.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener personas: " + e.getMessage());
            //e.printStackTrace();
        }
        return personas;
    }

    public void actualizarPersona(Persona persona) {
        String query = "UPDATE persona SET nombre = ?, apellido = ?, edad = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConexion();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar persona: " + e.getMessage());
            //e.printStackTrace();
        }
    }

    public void eliminarPersona(int id) {
        String query = "DELETE FROM persona WHERE id = ?";
        try (Connection conn = DBConnection.getConexion();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
