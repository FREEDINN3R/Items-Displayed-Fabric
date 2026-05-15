package net.freedinner.items_displayed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.freedinner.items_displayed.item.ModItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

public class ItemsDisplayedRecipeProvider extends FabricRecipeProvider {

    public ItemsDisplayedRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {

            @Override
            public void buildRecipes() {

                HolderGetter<Item> items=provider.lookupOrThrow(Registries.ITEM);

                offerItemDisplayRecipe(recipeOutput, items);

                offerJewelryPillowRecipe(recipeOutput,items,ModItems.BLACK_JEWELRY_PILLOW,Items.BLACK_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.BLUE_JEWELRY_PILLOW,Items.BLUE_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.BROWN_JEWELRY_PILLOW,Items.BROWN_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.CYAN_JEWELRY_PILLOW,Items.CYAN_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.GRAY_JEWELRY_PILLOW,Items.GRAY_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.GREEN_JEWELRY_PILLOW,Items.GREEN_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.LIGHT_BLUE_JEWELRY_PILLOW,Items.LIGHT_BLUE_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.LIGHT_GRAY_JEWELRY_PILLOW,Items.LIGHT_GRAY_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.LIME_JEWELRY_PILLOW,Items.LIME_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.MAGENTA_JEWELRY_PILLOW,Items.MAGENTA_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.ORANGE_JEWELRY_PILLOW,Items.ORANGE_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.PINK_JEWELRY_PILLOW,Items.PINK_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.PURPLE_JEWELRY_PILLOW,Items.PURPLE_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.RED_JEWELRY_PILLOW,Items.RED_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.WHITE_JEWELRY_PILLOW,Items.WHITE_WOOL);
                offerJewelryPillowRecipe(recipeOutput,items,ModItems.YELLOW_JEWELRY_PILLOW,Items.YELLOW_WOOL);
            }

            private void offerJewelryPillowRecipe(RecipeOutput output, HolderGetter<Item> items, ItemLike result, ItemLike wool) {
                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, result)
                        .pattern(" * ")
                        .pattern("/w/")
                        .define('*', Items.GOLD_NUGGET)
                        .define('/', Items.STICK)
                        .define('w', wool)
                        .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET))
                        .unlockedBy("has_stick", has(Items.STICK))
                        .unlockedBy("has_wool", has(wool))
                        .save(output);
            }
            private void offerItemDisplayRecipe(RecipeOutput output, HolderGetter<Item> items) {
                ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, ModItems.ITEM_DISPLAY)
                        .pattern(" / ")
                        .pattern("/ /")
                        .define('/', Items.STICK)
                        .unlockedBy("has_stick", has(Items.STICK))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Items Displayed Recipes";
    }

}
