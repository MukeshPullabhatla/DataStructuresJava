
public class DefangingAnIPAddress {
	public String defangIPaddr(String address) {
		String s = "";
		for(int i=0;i<address.length();i++) {
			char ch = address.charAt(i);
			if(!(ch=='.')) {
				s+=ch+"";
			}
			else {
				s+="[.]";
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
		DefangingAnIPAddress ob = new DefangingAnIPAddress();
		String address = "255.100.50.0";
		String result = ob.defangIPaddr(address);
		System.out.println(result);
	}

}
