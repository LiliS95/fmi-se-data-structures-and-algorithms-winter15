/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dimitar
 */
public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        System.out.println(list);
        list.insert(0, 10);
        list.insert(6, 11);
        System.out.println(list);

        list.reverse();

        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.remove();
            System.out.println(list);
        }
    }

}
