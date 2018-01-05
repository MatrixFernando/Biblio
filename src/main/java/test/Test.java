package test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte edad = -1;
		int sin_signo = edad & (0xff);

		System.out.println("ConSigno: " + edad + " SinSigno: " + sin_signo);
		
		
		int i = 234;
		byte b = (byte) i;
		System.out.println(b); // -22
		int i2 = b & 0xFF;
		System.out.println(i2); // 234
		
		byte ro = 127;
		System.out.println("df" + ro);
		
	
	int a=2;

	do {
	switch (a) {
	 
    case 1:
    System.out.println("aparece mensaje");
    
    a=5;
    break;

    case 2:
    System.out.println("holaa");
    
    a=1;
    if(a==2)
    {
    	
    }
    if(a==1)
    {
    	
    }
    break;
    
    case 3:
        ;
        break;
        
    default:
  //  sentencias;
    break;
    
	}}while(a!=5);
	System.out.println("ok");
	
	

		
	}

}
