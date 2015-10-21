public class Main {
	public static class Person{
		int label;
		boolean visit;
		ArrayList<Person> neighbors;
		public Person(int label){
			this.label = label;
			this.visit = false;
			neighbors = new ArrayList<Person>();
		}
	}
	public static void main(String[] args) {
        /* Enter your code here */
        Scanner sc = new Scanner(System.in);
        // initialize
        int N = sc.nextInt();// N person
        HashMap<Integer, Person> hmap = new HashMap<Integer, Person>();
        for(int i = 0; i < N; i++)
        	hmap.put(i, new Person(i));

        int M = sc.nextInt();// M relationship
        for(int i = 0; i < M; i++){
        	int p1 = sc.nextInt();
        	int p2 = sc.nextInt();
            hmap.get(p1).neighbors.add(hmap.get(p2));
            hmap.get(p2).neighbors.add(hmap.get(p1));
        }
        
        int K = sc.nextInt();
        int group = K;
        for(int i = 0; i < K; i++){
        	int p = sc.nextInt();
        	hmap.get(p).visit = true;
        }
        System.out.println(group + numberGroup(hmap));
    }
    public static int numberGroup(HashMap<Integer, Person> hmap){
        int count = 0;
        for(int i: hmap.keySet())
        	if(hmap.get(i).visit == false){
        		hmap.get(i).visit = true;
        		count++;
        		numberGroupHelper(hmap, hmap.get(i));
        	}
        return count;
    }
    public static void numberGroupHelper(HashMap<Integer, Person> hmap, Person p){
    	for(Person neighbor: p.neighbors){
    		if(neighbor.visit == false){
    			neighbor.visit = true;
    			numberGroupHelper(hmap, neighbor);
    		}
		}
    }
}
