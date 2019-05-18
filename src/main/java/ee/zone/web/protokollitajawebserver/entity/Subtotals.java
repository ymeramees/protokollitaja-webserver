package ee.zone.web.protokollitajawebserver.entity;

import org.bson.types.ObjectId;

public class Subtotals {

	private String id;
	private Series[] series;
	private String label;
	private String subtotal;
	
	public String getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id.toString();
	}
	public Series[] getSeries() {
		return series;
	}
	public void setSeries(Series[] series) {
		this.series = series;
	}
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
}
