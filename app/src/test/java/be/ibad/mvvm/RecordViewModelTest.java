package be.ibad.mvvm;

import android.content.Context;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import be.ibad.mvvm.model.Record;
import be.ibad.mvvm.test.MockModelsUtil;
import be.ibad.mvvm.viewModel.RecordViewModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by nvandamme on 13-07-17.
 * All right reserved for Immoweb MVVM_POC
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "./src/main/AndroidManifest.xml")
public class RecordViewModelTest extends Assert {

    private Record mDataModel;
    private RecordViewModel mViewModel;

    @Before
    public void setUp() throws Exception {
        mDataModel = MockModelsUtil.createMockFoodTruck();
        Context mContext = mock(Context.class);
        mViewModel = new RecordViewModel(mContext, mDataModel);
    }

    @Test
    public void testOnClickDetail() {
        assertNotNull(mViewModel.getFoodTruck());
        when(mViewModel.getFoodTruck()).thenReturn(mDataModel.getFields().getFriday());
    }

}
