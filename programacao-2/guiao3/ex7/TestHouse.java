/*
 * Este ficheiro serve apenas para testar os módulos House e Room
 */

import static java.lang.System.*;

public class TestHouse
{

   public static void main(String[] args){

	  House h = new House("apartment",7,4);

      Point p1  = new Point( 0.0, 2.0);
      Point p2  = new Point(22.0, 5.0);
      Point p3  = new Point( 8.0, 0.0);
      Point p4  = new Point( 8.0, 5.0);
      Point p5  = new Point( 0.0, 8.0);
      Point p6  = new Point(22.0, 8.0);
      Point p7  = new Point(11.0,14.0);
      Point p8  = new Point( 8.0, 8.0);
      Point p9  = new Point(11.0, 8.0);
      Point p10 = new Point(22.0,14.0);
      Point p11 = new Point(22.0, 0.0);
      Point p12 = new Point(28.0, 5.0);
      Point p13 = new Point(28.0,14.0);
      Point p14 = new Point(28.0,20.0);
      
      h.addRoom(new Room("quarto",p9,p10));
      h.addRoom(new Room("quarto",p5,p7));
      h.addRoom(new Room("hall", p1,p8));
      h.addRoom(new Room("sala",p3,p2));
      h.addRoom(new Room("corredor",p4,p6));
      h.addRoom(new Room("wc",p11,p12));
      h.addRoom(new Room("cozinha",p2,p13));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.addRoom(new Room("copa",p10,p14));
      h.printInfo();
   }
}


