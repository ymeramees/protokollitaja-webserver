package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

public class Series {

	private String id;
	private String seriesSum;
	
	public String getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id.toString();
	}
	public String getSeriesSum() {
		return seriesSum;
	}
	public void setSeriesSum(String seriesSum) {
		this.seriesSum = seriesSum;
	}
}
