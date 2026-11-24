import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Item {
    private String itemID;
    private String description;
    private String category;
    private String location;
    private LocalDate dateReported;
    private Student reportedBy;

    public Item(String itemID, String description, String category, String location, LocalDate dateReported, Student reportedBy) {
        this.itemID = itemID;
        this.description = description;
        this.category = category;
        this.location = location;
        this.dateReported = dateReported;
        this.reportedBy = reportedBy;
    }

    public String getItemID() {
        return itemID;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDateReported() {
        return dateReported;
    }

    public Student getReportedBy() {
        return reportedBy;
    }

    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }

    public boolean isOverdue(LocalDate today) {
        long daysPassed = ChronoUnit.DAYS.between(dateReported, today);
        return daysPassed > getHoldingDays() && !isResolved();
    }

    public boolean matchesKeyword(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return description.toLowerCase().contains(lowerKeyword) ||
               category.toLowerCase().contains(lowerKeyword) ||
               location.toLowerCase().contains(lowerKeyword);
    }

    protected void displayBasicInfo() {
        System.out.println("Item ID: " + itemID);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Location: " + location);
        System.out.println("Date Reported: " + dateReported);
        System.out.println("Reported By: " + reportedBy.getName() + " (" + reportedBy.getStudentID() + ")");
    }

    public abstract void displayItemInfo();
    public abstract int getHoldingDays();
    public abstract boolean isResolved();
}
