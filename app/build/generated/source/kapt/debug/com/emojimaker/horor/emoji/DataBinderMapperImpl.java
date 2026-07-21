package com.emojimaker.horor.emoji;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.emojimaker.horor.emoji.databinding.DialogAddNewPackageBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogAddPackageBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogColorPickerBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogConfirmBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogCreateNameBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogLoadingBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogRateBindingImpl;
import com.emojimaker.horor.emoji.databinding.DialogSpeechBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_DIALOGADDNEWPACKAGE = 1;

  private static final int LAYOUT_DIALOGADDPACKAGE = 2;

  private static final int LAYOUT_DIALOGCOLORPICKER = 3;

  private static final int LAYOUT_DIALOGCONFIRM = 4;

  private static final int LAYOUT_DIALOGCREATENAME = 5;

  private static final int LAYOUT_DIALOGLOADING = 6;

  private static final int LAYOUT_DIALOGRATE = 7;

  private static final int LAYOUT_DIALOGSPEECH = 8;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(8);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_add_new_package, LAYOUT_DIALOGADDNEWPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_add_package, LAYOUT_DIALOGADDPACKAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_color_picker, LAYOUT_DIALOGCOLORPICKER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_confirm, LAYOUT_DIALOGCONFIRM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_create_name, LAYOUT_DIALOGCREATENAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_loading, LAYOUT_DIALOGLOADING);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_rate, LAYOUT_DIALOGRATE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.emojimaker.horor.emoji.R.layout.dialog_speech, LAYOUT_DIALOGSPEECH);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_DIALOGADDNEWPACKAGE: {
          if ("layout/dialog_add_new_package_0".equals(tag)) {
            return new DialogAddNewPackageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_add_new_package is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGADDPACKAGE: {
          if ("layout/dialog_add_package_0".equals(tag)) {
            return new DialogAddPackageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_add_package is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCOLORPICKER: {
          if ("layout/dialog_color_picker_0".equals(tag)) {
            return new DialogColorPickerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_color_picker is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCONFIRM: {
          if ("layout/dialog_confirm_0".equals(tag)) {
            return new DialogConfirmBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_confirm is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCREATENAME: {
          if ("layout/dialog_create_name_0".equals(tag)) {
            return new DialogCreateNameBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_create_name is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGLOADING: {
          if ("layout/dialog_loading_0".equals(tag)) {
            return new DialogLoadingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_loading is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGRATE: {
          if ("layout/dialog_rate_0".equals(tag)) {
            return new DialogRateBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_rate is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGSPEECH: {
          if ("layout/dialog_speech_0".equals(tag)) {
            return new DialogSpeechBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_speech is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(8);

    static {
      sKeys.put("layout/dialog_add_new_package_0", com.emojimaker.horor.emoji.R.layout.dialog_add_new_package);
      sKeys.put("layout/dialog_add_package_0", com.emojimaker.horor.emoji.R.layout.dialog_add_package);
      sKeys.put("layout/dialog_color_picker_0", com.emojimaker.horor.emoji.R.layout.dialog_color_picker);
      sKeys.put("layout/dialog_confirm_0", com.emojimaker.horor.emoji.R.layout.dialog_confirm);
      sKeys.put("layout/dialog_create_name_0", com.emojimaker.horor.emoji.R.layout.dialog_create_name);
      sKeys.put("layout/dialog_loading_0", com.emojimaker.horor.emoji.R.layout.dialog_loading);
      sKeys.put("layout/dialog_rate_0", com.emojimaker.horor.emoji.R.layout.dialog_rate);
      sKeys.put("layout/dialog_speech_0", com.emojimaker.horor.emoji.R.layout.dialog_speech);
    }
  }
}
