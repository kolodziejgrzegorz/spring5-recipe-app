package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand uomToCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService uomService;

    @Mock
    UnitOfMeasureRepository uomRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        uomService = new UnitOfMeasureServiceImpl(uomRepository, uomToCommand);
    }

    @Test
    public void testFindAll() {

        Set<UnitOfMeasure> unitOfMeasure = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom1.setId(1L);
        uom2.setId(2L);
        unitOfMeasure.add(uom1);
        unitOfMeasure.add(uom2);

        when(uomRepository.findAll()).thenReturn(unitOfMeasure);

        Set<UnitOfMeasureCommand> commands = uomService.findAll();

        assertEquals(2, commands.size());
        verify(uomRepository,times(1)).findAll();
    }
}