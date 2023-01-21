import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import util.HibernateUtil;

public class connectionTest {
    @Test
    public void connectionViaHibernate(){
        SessionFactory factory = HibernateUtil.getFactory();
        Assert.assertNotEquals(factory,null);

    }
}
