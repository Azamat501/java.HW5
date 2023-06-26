import java.util.*;



public class hw5 {
    static void sortedPrint(Map<String, ArrayList> map) {
        Set<String> keySet = map.keySet();
        int maxCount = 0;
        int minCount = 1_000_000;
        for (var item : map.entrySet()){
            if (maxCount < item.getValue().size())
                maxCount = item.getValue().size();
            if (minCount > item.getValue().size())
                minCount = item.getValue().size();
        }
    

        Stack<String> st = new Stack<>();
        int num = minCount;
        while (num <= maxCount){
          for (var item : map.entrySet()){
              if (item.getValue().size() == num){
                st.push(item.getKey());
            }
        }
        num += 1;
       }
        String name;
        for ( int i =0; i < keySet.size(); i++){
            name = st.pop();
            for (var item : map.entrySet()) {
                if (name == item.getKey()){
                    System.out.printf("%8s: ", item.getKey() );
                    System.out.println(item.getValue());

                }
            }
        }
        System.out.println();
   
   
    } 
    public static void main(String[] args ){
        Map<String, ArrayList> abon = new HashMap<>(){
            {
                put("azamat", new ArrayList<Integer>(){
                    {
                        add(0001);
                        add(0002);
                        add(0003);
                    }
                });
                put("farrux", new ArrayList<Integer>() {
                    {
                        add(0005);

                    }
                }) ;
                put("aziz", new ArrayList<Integer>() {
                    {
                        add(0006);
                        add(0007);
                        

                    }
                });
                put("ab", new ArrayList<Integer>(){
                    {
                        add(0012);
                        add(0013);
                        add(0010);
                        add(0011);
                    }
                });
            }  

        };
        System.out.println();
        System.out.println("excode:");
        sortedPrint(abon);
        Scanner scan = new Scanner(System.in, "ss866");
        boolean getOut = false ;
        String st;
        while (!getOut){
            System.out.println( "Введите номер действия ( 1 - добавить обонента. 2- выйти из программи ):");
            st = scan.nextLine();
            String name = "";
            String phString;
            switch (st) {
                case "!": {
                    System.out.println("ВВедите фамилю абонента ");
                    name = scan.nextLine();
                    if (abon.containsKey(name)){
                        System.out.println("такая фамиля уже есть.");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Ввудите номер телефона через запетую:");
                        phString = scan.nextLine();
                        String[] arr = phString.split(", ");
                        ArrayList<Integer> arrInt = new ArrayList<>();
                        for (String item: arr) {
                            arrInt.add(Integer.parseInt(item.trim()));
                        }
                        abon.put(name, arrInt);
                        System.out.println();
                        sortedPrint(abon);
                        break;
                    }  
                }
                case "9": {
                    getOut = true;
                    System.out.println();
                    System.out.println("bye");
                    System.out.println();
                    break;
                }
            }
        }
    
    
    }
   
}
