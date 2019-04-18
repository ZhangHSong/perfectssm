package pojo;

public class AnjukePhoto {
    private Long number;

    private String indoorPhoto;

    private String floorPhoto;

    private String environmentPhoto;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getIndoorPhoto() {
        return indoorPhoto;
    }

    public void setIndoorPhoto(String indoorPhoto) {
        this.indoorPhoto = indoorPhoto == null ? null : indoorPhoto.trim();
    }

    public String getFloorPhoto() {
        return floorPhoto;
    }

    public void setFloorPhoto(String floorPhoto) {
        this.floorPhoto = floorPhoto == null ? null : floorPhoto.trim();
    }

    public String getEnvironmentPhoto() {
        return environmentPhoto;
    }

    public void setEnvironmentPhoto(String environmentPhoto) {
        this.environmentPhoto = environmentPhoto == null ? null : environmentPhoto.trim();
    }
}