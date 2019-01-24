package ee.zone.web.protokollitajawebserver.entity;

public class EventHeader {

	private String id;
	private String eventName;
	
	public EventHeader() {
		// TODO Auto-generated constructor stub
	}
	
	public EventHeader(String id, String name) {
		this.id = id;
		this.eventName = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}
