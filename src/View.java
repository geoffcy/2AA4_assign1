
public class View {
	public static void QuickDraw(Model m){
		for (int y=0; y < 5; y++){
			for (int x=0; x < 5; x++){
				System.out.print(m.getToken(x, y)+", ");
			}
			System.out.println();
		}
	}
}
