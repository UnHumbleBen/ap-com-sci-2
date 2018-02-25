public class HorseBarnTester
{
    public static void main(String[] args) {
        Horse[] spaces = new Horse[7];
        
        Horse Trigger = new HorseA("Trigger", 1340);
        Horse Silver = new HorseA("Silver", 1210);
        Horse Lady = new HorseA("Lady", 1575);
        Horse Patches = new HorseA("Patches", 1350);
        Horse Duke = new HorseA("Duke", 1410);
        
        spaces[0] = Trigger;
        spaces[2] = Silver;
        spaces[3] = Lady;
        spaces[5] = Patches;
        spaces[6] = Duke;
        
        HorseBarn sweetHome = new HorseBarn(spaces);
        
        System.out.println(sweetHome.findHorseSpace("Trigger"));
        System.out.println(sweetHome.findHorseSpace("Silver"));
        System.out.println(sweetHome.findHorseSpace("Coco"));
        sweetHome.printSpaces();
        sweetHome.consolidate();
        sweetHome.printSpaces();
    }
}
