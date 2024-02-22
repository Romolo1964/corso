package lib;
    import org.hibernate.MappingException;
import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;
public class Text {
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("lib/hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();
System.out.println(session);
        try {
        	System.out.println("Sto dentro al try ");
        	System.out.println("session");
        	
            // Operazioni sul database usando session
            // Esempio: Salvataggio di un oggetto
           ClasseModello oggetto = new ClasseModello();
           oggetto.setCampo1("Valore1");
           oggetto.setCampo2("Valore2");

          session.beginTransaction();
           session.save(oggetto);
           session.getTransaction().commit();
        } 
        catch (MappingException exc) {
        	System.out.println("Non trovo la clesse entità non è mappata dentro il file cfg");
        }
        
        finally {
            factory.close();
        }
    }
}

