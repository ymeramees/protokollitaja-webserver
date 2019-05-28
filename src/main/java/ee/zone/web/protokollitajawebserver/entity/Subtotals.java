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
        // Hardcoded translations to Estonian language until better translation system is implemented
        switch (label) {
            case "Kneeling":
                this.label = "Põlvelt";
                break;
            case "Prone":
                this.label = "Lamades";
                break;
            case "Standing":
                this.label = "Püsti";
                break;
            case "Stage 1":
                this.label = "I pool";
                break;
            case "Stage 2":
                this.label = "II pool";
                break;
            case "Precision":
                this.label = "Ringmärk";
                break;
            case "Rapid":
                this.label = "Ilmuv märk";
                break;
            case "Slow run":
                this.label = "Aeglane jooks";
                break;
            case "Rapid run":
                this.label = "Kiire jooks";
                break;
            case "Series":
                this.label = "";
                break;
            default:
                this.label = label;
        }
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }
}
