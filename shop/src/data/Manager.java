package data;

public class Manager {
	
	public static Manager instance = new Manager();

	private String managerCode = "0000";
	
	public String getManagerCode() {
		return managerCode;
	}
	
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}
	
}
