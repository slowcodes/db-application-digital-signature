package ng.com.bitsystems.digitalsignature.converters;

import ng.com.bitsystems.digitalsignature.command.CountiesCommand;
import ng.com.bitsystems.digitalsignature.model.Counties;
import ng.com.bitsystems.digitalsignature.model.States;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class CountiesToCountiesCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final States STATE = new States();
    CountiesToCountiesCommand conveter;

    @BeforeEach
    void setUp() {
        conveter = new CountiesToCountiesCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(conveter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(conveter.convert(new Counties()));
    }


    @Test
    public void convert() throws Exception {
        //given
        CountiesCommand countiesCommand = new CountiesCommand();
        countiesCommand.setId(ID_VALUE);
        //countiesCommand.setDescription(DESCRIPTION);

        //when
//        Counties counties = conveter.convert(countiesCommand);
//
//        //then
//        assertEquals(ID_VALUE, counties.getId());
//        assertEquals(STATE, counties.getState());
    }

}