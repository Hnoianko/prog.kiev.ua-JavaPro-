package ua.kiev.prog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            try {
                Menu positionOne = new Menu("Coffee", 100.0, 150.0, false);
                Menu positionTwo = new Menu("Tea", 50.0, 280.0, false);
                Menu positionThree = new Menu("Soup", 100.0, 300.0, true);
                Menu positionFour = new Menu("Pasta", 200.0, 280.0, false);
                Menu positionFive = new Menu("Pizza", 180.0, 500.0, true);
                Menu positionSix = new Menu("Cake", 200.0, 300.0, false);
                Menu[] menu = {positionOne, positionTwo, positionThree, positionFour, positionFive, positionSix};
                for (Menu m : menu) {
                    em.persist(m);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
                return;
            }

            //Select dishes with price from 50 to 150
            System.out.println("------------------ #2 ------------------");
            Query query = em.createQuery("SELECT c FROM Menu c WHERE c.dishPrice < 150 and c.dishPrice>50", Menu.class);
            List<Menu> menuList = query.getResultList();

            for (Menu m : menuList) {
                System.out.println(m);
            }

            //Select dishes with discount
            System.out.println("------------------ #3 ------------------");
            Query queryTwo = em.createQuery("SELECT c FROM Menu c WHERE c.discount = true", Menu.class);
            List<Menu> menuListTwo = queryTwo.getResultList();

            for (Menu menu : menuListTwo) {
                System.out.println(menu);
            }

            //Select dishes set with weight 1000less
            System.out.println("------------------ #4 ------------------");
            Query queryFour = em.createQuery("SELECT c FROM Menu c", Menu.class);
            List<Menu> menuListFour = queryFour.getResultList();
            List<Menu> menuListMaxWeight = new ArrayList<>();
            int maxWeight = 1000;
            int sum = 0;
            for (int i = 0; i < menuListFour.size(); i++) {
                sum += sum + menuListFour.get(i).getDishWeight();
                menuListMaxWeight.add(menuListFour.get(i));
                if (sum > maxWeight) {
                    break;
                }
            }
            for (Menu menu : menuListMaxWeight) {
                System.out.println(menu);
            }

        } finally {
            em.close();
            emf.close();
        }

    }
}