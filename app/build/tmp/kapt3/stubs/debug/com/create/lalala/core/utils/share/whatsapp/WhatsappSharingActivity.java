package com.create.lalala.core.utils.share.whatsapp;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u0012*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\u0011\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/create/lalala/core/utils/share/whatsapp/WhatsappSharingActivity;", "DB", "Landroidx/viewbinding/ViewBinding;", "Lcom/create/lalala/core/base/BaseActivity;", "<init>", "()V", "addToWhatsapp", "", "sp", "Lcom/create/lalala/core/utils/share/whatsapp/StickerPack;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "addStickerPackageToWhatsApp", "showErrorDialog", "Companion", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_debug"})
public abstract class WhatsappSharingActivity<DB extends androidx.viewbinding.ViewBinding> extends com.create.lalala.core.base.BaseActivity<DB> {
    @java.lang.Deprecated()
    public static final int ADD_PACK_REQUEST = 200;
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String EXTRA_STICKER_PACK_ID = "sticker_pack_id";
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String EXTRA_STICKER_PACK_AUTHORITY = "sticker_pack_authority";
    @org.jetbrains.annotations.NotNull()
    @java.lang.Deprecated()
    public static final java.lang.String EXTRA_STICKER_PACK_NAME = "sticker_pack_name";
    @org.jetbrains.annotations.NotNull()
    private static final com.create.lalala.core.utils.share.whatsapp.WhatsappSharingActivity.Companion Companion = null;
    
    public WhatsappSharingActivity() {
        super();
    }
    
    public final void addToWhatsapp(@org.jetbrains.annotations.NotNull()
    com.create.lalala.core.utils.share.whatsapp.StickerPack sp) {
    }
    
    @java.lang.Override()
    @java.lang.Deprecated()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void addStickerPackageToWhatsApp(com.create.lalala.core.utils.share.whatsapp.StickerPack sp) {
    }
    
    public final void showErrorDialog() {
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/create/lalala/core/utils/share/whatsapp/WhatsappSharingActivity$Companion;", "", "<init>", "()V", "ADD_PACK_REQUEST", "", "EXTRA_STICKER_PACK_ID", "", "EXTRA_STICKER_PACK_AUTHORITY", "EXTRA_STICKER_PACK_NAME", "ST295_Horror_Emoji_Maker_v1.0.0_07.20.2026_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}