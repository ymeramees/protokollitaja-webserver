package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

public class Event {

	private String id;
	//private int id;
	private String eventName;
	private Competitor[] competitors;

	public Event() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id.toString();
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

	public Competitor[] getCompetitors() {
		return competitors;
	}
	public void setCompetitors(Competitor[] competitors) {
		this.competitors = competitors;
	}
}
