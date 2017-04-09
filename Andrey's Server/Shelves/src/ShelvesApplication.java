import services.BookService;
import services.UserService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by adaico on 26.03.17.
 */
@ApplicationPath("/")
public class ShelvesApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet<Class<?>>();
        classes.add(BookService.class);
        classes.add(UserService.class);
        return classes;
    }
}

