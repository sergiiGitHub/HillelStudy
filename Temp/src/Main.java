import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergii on 25.11.18.
 */
public class Main {

    private static String packages[] = {"123", "321"};

    public static void main(String args[]) {

        List<Model> list = new ArrayList<>();
        int i = 0;
        for(; i < 5; ++i) {
            Model m = new Model(i, packages[i % packages.length]);
            list.add(m);
        }
        Holder holder = new Holder(list);
        System.out.println("original:\t" + holder);
        Model m = new Model(i, packages[i%packages.length]);
        list.add(m);
        holder.update(list);
        System.out.println("after Add:\t" + holder);

        list.remove(new Model(3, packages[3 % packages.length]));
        holder.update(list);
        System.out.println("after Rem:\t" + holder);

        holder.update(list);
        System.out.println("after Same:\t" + holder);

        holder.update(list);
        System.out.println("after Same:\t" + holder);
    }
}
