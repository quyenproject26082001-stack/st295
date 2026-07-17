package com.create.lalala.core.utils;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$J\u001e\u0010*\u001a\u0012\u0012\u0004\u0012\u00020+0\"j\b\u0012\u0004\u0012\u00020+`$2\u0006\u0010,\u001a\u00020-J\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020+0\"j\b\u0012\u0004\u0012\u00020+`$J\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u00020+0\"j\b\u0012\u0004\u0012\u00020+`$2\u0006\u0010,\u001a\u00020-R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R!\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/0\"j\b\u0012\u0004\u0012\u00020/`$\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R!\u00102\u001a\u0012\u0012\u0004\u0012\u00020/0\"j\b\u0012\u0004\u0012\u00020/`$\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00101\u00a8\u00066"}, d2 = {"Lcom/create/lalala/core/utils/DataLocal;", "", "<init>", "()V", "shimmer", "Lcom/facebook/shimmer/Shimmer;", "kotlin.jvm.PlatformType", "getShimmer", "()Lcom/facebook/shimmer/Shimmer;", "lastClickTime", "", "getLastClickTime", "()J", "setLastClickTime", "(J)V", "currentDate", "", "getCurrentDate", "()Ljava/lang/String;", "setCurrentDate", "(Ljava/lang/String;)V", "isConnectInternet", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setConnectInternet", "(Landroidx/lifecycle/MutableLiveData;)V", "isFailBaseURL", "()Z", "setFailBaseURL", "(Z)V", "isCallDataAlready", "setCallDataAlready", "getLanguageList", "Ljava/util/ArrayList;", "Lcom/create/lalala/data/model/LanguageModel;", "Lkotlin/collections/ArrayList;", "itemIntroList", "", "Lcom/create/lalala/data/model/IntroModel;", "getItemIntroList", "()Ljava/util/List;", "getBackgroundColorDefault", "Lcom/create/lalala/data/model/SelectedModel;", "context", "Landroid/content/Context;", "bottomNavigationNotSelect", "", "getBottomNavigationNotSelect", "()Ljava/util/ArrayList;", "bottomNavigationSelected", "getBottomNavigationSelected", "getTextFontDefault", "getTextColorDefault", "ST295_Horror_Emoji_Maker_v1.0.0_07.17.2026_debug"})
public final class DataLocal {
    private static final com.facebook.shimmer.Shimmer shimmer = null;
    private static long lastClickTime = 0L;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String currentDate = "";
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isConnectInternet;
    private static boolean isFailBaseURL = false;
    private static boolean isCallDataAlready = false;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<com.create.lalala.data.model.IntroModel> itemIntroList = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<java.lang.Integer> bottomNavigationNotSelect = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.ArrayList<java.lang.Integer> bottomNavigationSelected = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.create.lalala.core.utils.DataLocal INSTANCE = null;
    
    private DataLocal() {
        super();
    }
    
    public final com.facebook.shimmer.Shimmer getShimmer() {
        return null;
    }
    
    public final long getLastClickTime() {
        return 0L;
    }
    
    public final void setLastClickTime(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    public final void setCurrentDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isConnectInternet() {
        return null;
    }
    
    public final void setConnectInternet(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    public final boolean isFailBaseURL() {
        return false;
    }
    
    public final void setFailBaseURL(boolean p0) {
    }
    
    public final boolean isCallDataAlready() {
        return false;
    }
    
    public final void setCallDataAlready(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.create.lalala.data.model.LanguageModel> getLanguageList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.create.lalala.data.model.IntroModel> getItemIntroList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.create.lalala.data.model.SelectedModel> getBackgroundColorDefault(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getBottomNavigationNotSelect() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getBottomNavigationSelected() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.create.lalala.data.model.SelectedModel> getTextFontDefault() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.create.lalala.data.model.SelectedModel> getTextColorDefault(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}