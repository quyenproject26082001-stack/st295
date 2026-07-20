package com.create.lalala.databinding;
import com.create.lalala.R;
import com.create.lalala.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogColorPickerBindingImpl extends DialogColorPickerBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 1);
        sViewsWithIds.put(R.id.top, 2);
        sViewsWithIds.put(R.id.colorPickerView, 3);
        sViewsWithIds.put(R.id.hueSlider, 4);
        sViewsWithIds.put(R.id.btnDone, 5);
        sViewsWithIds.put(R.id.btnDoneText, 6);
        sViewsWithIds.put(R.id.btnClose, 7);
        sViewsWithIds.put(R.id.btnCancelText, 8);
        sViewsWithIds.put(R.id.btnStringColor, 9);
        sViewsWithIds.put(R.id.tvColorString, 10);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogColorPickerBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private DialogColorPickerBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[8]
            , (android.widget.RelativeLayout) bindings[7]
            , (android.widget.RelativeLayout) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.RelativeLayout) bindings[9]
            , (ir.kotlin.kavehcolorpicker.KavehColorPicker) bindings[3]
            , (ir.kotlin.kavehcolorpicker.KavehHueSlider) bindings[4]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.TextView) bindings[10]
            , (com.create.lalala.core.custom.text.DoubleStrokeTextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}