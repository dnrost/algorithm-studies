import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer1 {

	private List<String> servers;
	private AtomicInteger index = new AtomicInteger(0);
	
	public LoadBalancer1(List<String> servers) {
		this.servers = servers;
	}
	
	public String getNextServer() {
		int nextIndex = index.getAndUpdate(i -> (i+1) % servers.size()); //round robin logic
		return servers.get(nextIndex);
	}
	
	public static void main(String[] args) {
		List<String> servers = List.of("1", "2", "3");
		LoadBalancer1 lb = new LoadBalancer1(servers);
		int req = 10000;
		for (int i = 0; i < req; i++) {
			String nextServer = "server " + lb.getNextServer();
			System.out.println("Request " + (i+1) + " routed to: " + nextServer);			
		}		
	}
}
