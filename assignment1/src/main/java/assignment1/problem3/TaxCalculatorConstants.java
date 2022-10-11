package assignment1.problem3;

/**
 * Class contains all constants used for calculations
 */
public final class TaxCalculatorConstants {

  /**
   * Retirement and health savings deduction, For group tax filers, the health and retirement deduction is calculated by also
   * summing up their reported retirement and health savings contributions, but the
   * sum is now multiplied by 0.65
   */
  public static final Double GRP_RET_CONT = 0.65;
  /**
   * Retirement and health savings deduction, For group tax filers, Any result higher than $17500 is floored to $17500.
   */
  public static final Double HEALTH_RET_CON =17_500.0;
  /**
   * If the retirement and health savings deduction is higher than the current taxable
   * income, then the difference between the taxable income and the deduction is set
   * to be equal to 0
   */
  public static final Double ZERO_TAX_INCOME = 0.0;
  /**
   * all tax filers who have earned less than $250 000 last year
   */
  public static final Double MIN_EARN_MORT = 250_000.0;
  /**
   * all tax filers who have reported more than $12500 in mortgage interests and
   * property taxes expenses
   */
  public static final Double MORT_PRO_CONT = 12_500.0;
  /**
   * $2500 mortgage interest and property tax deduction, maximum can be applied
   */
  public static final Double MORT_PRO_DEDUCT = 2_500.0;
  /**
   * All group filers who have reported more than $5000 in childcare expenses
   */
  public static final Double MAX_CHILD_EXP = 5_000.0;
  /**
   * All group tax filers who have earned less than $200000
   */
  public static final Double MIN_EARN_INCOME = 200_000.0;
  /**
   * All group filers can apply $1250 childcare deduction
   */
  public static final Double MAX_CHILD_DEDUCT = 1_250.0;
  /**
   * amount for group filers, taxable income higher than $90000
   */
  public static final Double GRP_INCOME_90000 = 90_000.0;
  /**
   * For individual tax filers with the resulting taxable income higher than $55 000
   */
  public static final Double IND_INCOME_55000 = 55_000.0;
  /**
   * for group, resulting taxable income lower than $90000, the tax
   * amount is calculated by multiplying the resulting taxable income by 0.145
   */
  public static final Double GRP_MIN_INTEREST = 0.145;
  /**
   * for group, resulting taxable income higher than $90000, the
   * tax amount is calculated by multiplying the resulting taxable income by 0.185.
   */
  public static final Double GRP_MAX_INTEREST = 0.185;
  /**
   * For individual tax filers with the resulting taxable income lower than $55 000, the tax amount is calculated by multiplying the resulting taxable income by 0.15
   */
  public static final Double IND_MIN_INTEREST = 0.15;
  /**
   * For individual tax filers with the resulting taxable income higher than $55 000, the tax amount is calculated by multiplying the resulting taxable income by 0.19.
   */
  public static final Double IND_MAX_INTEREST = 0.19;
  /**
   * For Retirement and health savings deduction, by individual filers, the health and retirement savings deduction is
   * calculated by summing up their reported retirement and health savings
   * contributions, and multiplying the sum by 0.7
   */
  public static final Double IND_POINT_7 = 0.7;

  /**
   * Private the constructor to restrict to create an instance of this class
   */
  private TaxCalculatorConstants() {}

}
