package mn.dae.pc.notifications.enums;

/**
 * Enum for template status
 */
public enum TemplateStatus {

  TEMPLATE_APPROVED(" APPROVED"),
  TEMPLATE_PENDING(" PENDING"),
  TEMPLATE_REJECTED("REJECTED");

  private final String value;

  TemplateStatus(String value) {
    this.value = value;
  }

  /**
   * Get the value of the enum
   *
   * @param status         template status.
   * @return TemplateStatus
   */
  public static TemplateStatus fromValue(String status) {
    try {
      return TemplateStatus.valueOf(status);
    } catch (IllegalArgumentException e) {
      return null;
    }
  }

}
