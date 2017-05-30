public class MapSetActivityTester {
	public static void main(String[] args) {	

		System.out.println("Team Set");
		TeamSet one = new TeamSet();
		one.add(new Wrestler("Alok", 130));

		one.add(new Wrestler("Cody", 60));
		one.add(new Wrestler("John", 90));
		one.display();
		System.out.println(one.avgWeight());
		System.out.println(one.lightweights());
		System.out.println();
		System.out.println("Team Map");
		TeamMap a=new TeamMap();
		a.add(new Wrestler("Bob",157));
		a.add(new Wrestler("Fred",129));
		a.add(new Wrestler("Jake",100));
		a.add(new Wrestler("Arnold",199));
		a.add(new Wrestler("Stan",120));
		Wrestler juan = new Wrestler("Juan",180);
		a.add(juan);
		System.out.println(a);
		a.changeWeightGroup(juan,10);
		System.out.println("Juan is in Weight Group " +a.get(juan));
		System.out.println();

		System.out.println(a);


	}
}

/*Team Set
Cody 60
Alok 130
John 90
93.33333333333333
[Cody 60, John 90]

Team Map
Jake 100--> Weight Group 0
Bob 157--> Weight Group 5
Stan 120--> Weight Group 2
Fred 129--> Weight Group 2
Juan 180--> Weight Group 8
Arnold 199--> Weight Group 9

Juan is in Weight Group 10

Jake 100--> Weight Group 0
Bob 157--> Weight Group 5
Stan 120--> Weight Group 2
Fred 129--> Weight Group 2
Juan 180--> Weight Group 10
Arnold 199--> Weight Group 9*/