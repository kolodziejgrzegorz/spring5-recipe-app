package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootrapMySQL implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootrapMySQL(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(categoryRepository.count()==0L){
            log.debug("Load category");
            loadCategories();
        }
        if(unitOfMeasureRepository.count()==0L){
            log.debug("Load UOMs");
            loadUom();
        }
    }

    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setDescription("American");
        categoryRepository.save(cat1);

        Category cat2 = new Category();
        cat2.setDescription("Italian");
        categoryRepository.save(cat2);

        Category cat3 = new Category();
        cat3.setDescription("Mexican");
        categoryRepository.save(cat3);

        Category cat4 = new Category();
        cat4.setDescription("Fast Food");
        categoryRepository.save(cat4);
    }

    private void loadUom(){
        UnitOfMeasure uom1 = new UnitOfMeasure();
        UnitOfMeasure uom2 = new UnitOfMeasure();
        UnitOfMeasure uom3 = new UnitOfMeasure();
        UnitOfMeasure uom4 = new UnitOfMeasure();
        UnitOfMeasure uom5 = new UnitOfMeasure();
        UnitOfMeasure uom6 = new UnitOfMeasure();
        UnitOfMeasure uom7 = new UnitOfMeasure();
        UnitOfMeasure uom8 = new UnitOfMeasure();

        uom1.setDescription("Teaspoon");
        uom2.setDescription("Tablespoon");
        uom3.setDescription("Cup");
        uom4.setDescription("Pinch");
        uom5.setDescription("Ounce");
        uom6.setDescription("Dash");
        uom7.setDescription("Pint");
        uom8.setDescription("Each");

        unitOfMeasureRepository.save(uom1);
        unitOfMeasureRepository.save(uom2);
        unitOfMeasureRepository.save(uom3);
        unitOfMeasureRepository.save(uom4);
        unitOfMeasureRepository.save(uom5);
        unitOfMeasureRepository.save(uom6);
        unitOfMeasureRepository.save(uom7);
        unitOfMeasureRepository.save(uom8);
    }
}
