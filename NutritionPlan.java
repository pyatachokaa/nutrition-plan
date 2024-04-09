import java.util.List;
import java.util.Arrays;

class NutritionPlan {
    private int caloricIntake;
    private int carbohydratesRatio;
    private int proteinsRatio;
    private int fatsRatio;
    private List<String> mealPlans;
    private String fitnessGoal;
    private List<String> dietaryRestrictions;

    public NutritionPlan(int caloricIntake, int carbohydratesRatio, int proteinsRatio, int fatsRatio,
                         List<String> mealPlans, String fitnessGoal, List<String> dietaryRestrictions) {
        this.caloricIntake = caloricIntake;
        this.carbohydratesRatio = carbohydratesRatio;
        this.proteinsRatio = proteinsRatio;
        this.fatsRatio = fatsRatio;
        this.mealPlans = mealPlans;
        this.fitnessGoal = fitnessGoal;
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public int getCaloricIntake() {
        return caloricIntake;
    }

    public void setCaloricIntake(int caloricIntake) {
        this.caloricIntake = caloricIntake;
    }

    public int getCarbohydratesRatio() {
        return carbohydratesRatio;
    }

    public void setCarbohydratesRatio(int carbohydratesRatio) {
        this.carbohydratesRatio = carbohydratesRatio;
    }

    public int getProteinsRatio() {
        return proteinsRatio;
    }

    public void setProteinsRatio(int proteinsRatio) {
        this.proteinsRatio = proteinsRatio;
    }

    public int getFatsRatio() {
        return fatsRatio;
    }

    public void setFatsRatio(int fatsRatio) {
        this.fatsRatio = fatsRatio;
    }

    public List<String> getMealPlans() {
        return mealPlans;
    }

    public void setMealPlans(List<String> mealPlans) {
        this.mealPlans = mealPlans;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(List<String> dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}

interface NutritionPlanBuilder {
    NutritionPlanBuilder setCaloricIntake(int caloricIntake);
    NutritionPlanBuilder setCarbohydratesRatio(int carbohydratesRatio);
    NutritionPlanBuilder setProteinsRatio(int proteinsRatio);
    NutritionPlanBuilder setFatsRatio(int fatsRatio);
    NutritionPlanBuilder setMealPlans(List<String> mealPlans);
    NutritionPlanBuilder setFitnessGoal(String fitnessGoal);
    NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions);
    NutritionPlan build();
}

class NutritionPlanDirector {
    private NutritionPlanBuilder builder;

    public void setBuilder(NutritionPlanBuilder builder) {
        this.builder = builder;
    }

    public NutritionPlan createNutritionPlan() {
        return builder.build();
    }
}

class WeightLossNutritionPlanBuilder implements NutritionPlanBuilder {
    private NutritionPlan nutritionPlan;

    public WeightLossNutritionPlanBuilder() {
        this.nutritionPlan = new NutritionPlan(1500, 40, 30, 30,
                Arrays.asList("Breakfast", "Lunch", "Dinner"),
                "Weight Loss",
                Arrays.asList("Gluten-free", "Dairy-free"));
    }

    @Override
    public NutritionPlanBuilder setCaloricIntake(int caloricIntake) {
        this.nutritionPlan.setCaloricIntake(caloricIntake);
        return this;
    }

    @Override
    public NutritionPlanBuilder setCarbohydratesRatio(int carbohydratesRatio) {
        this.nutritionPlan.setCarbohydratesRatio(carbohydratesRatio);
        return this;
    }

    @Override
    public NutritionPlanBuilder setProteinsRatio(int proteinsRatio) {
        this.nutritionPlan.setProteinsRatio(proteinsRatio);
        return this;
    }

    @Override
    public NutritionPlanBuilder setFatsRatio(int fatsRatio) {
        this.nutritionPlan.setFatsRatio(fatsRatio);
        return this;
    }

    @Override
    public NutritionPlanBuilder setMealPlans(List<String> mealPlans) {
        this.nutritionPlan.setMealPlans(mealPlans);
        return this;
    }

    @Override
    public NutritionPlanBuilder setFitnessGoal(String fitnessGoal) {
        return this;
    }

    @Override
    public NutritionPlanBuilder setDietaryRestrictions(List<String> dietaryRestrictions) {
        this.nutritionPlan.setDietaryRestrictions(dietaryRestrictions);
        return this;
    }

    @Override
    public NutritionPlan build() {
        return this.nutritionPlan;
    }
}

class Main {
    public static void main(String[] args) {
        NutritionPlanDirector director = new NutritionPlanDirector();
        WeightLossNutritionPlanBuilder builder = new WeightLossNutritionPlanBuilder();

        director.setBuilder(builder);

        NutritionPlan nutritionPlan = director.createNutritionPlan();

        System.out.println("Nutrition Plan:");
        System.out.println("Caloric Intake: " + nutritionPlan.getCaloricIntake());
        System.out.println("Carbohydrates Ratio: " + nutritionPlan.getCarbohydratesRatio());
        System.out.println("Proteins Ratio: " + nutritionPlan.getProteinsRatio());
        System.out.println("Fats Ratio: " + nutritionPlan.getFatsRatio());
        System.out.println("Meal Plans: " + nutritionPlan.getMealPlans());
        System.out.println("Fitness Goal: " + nutritionPlan.getFitnessGoal());
        System.out.println("Dietary Restrictions: " + nutritionPlan.getDietaryRestrictions());
    }
}
