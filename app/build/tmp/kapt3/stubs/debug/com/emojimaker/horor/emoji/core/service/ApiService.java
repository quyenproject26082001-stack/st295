package com.emojimaker.horor.emoji.core.service;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2 = {"Lcom/emojimaker/horor/emoji/core/service/ApiService;", "", "getAllData", "Lretrofit2/Response;", "", "", "", "Lcom/emojimaker/horor/emoji/data/model/PartAPI;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEmojiData", "Lcom/emojimaker/horor/emoji/data/model/emoji/EmojiApiResponse;", "ST295_Horror_Emoji_Maker_V1.0.1_07.23.2026_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "api/app/ST295_HorrorEmojiMaker")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.util.List<com.emojimaker.horor.emoji.data.model.PartAPI>>>> $completion);
    
    @retrofit2.http.GET(value = "api/ST295_HorrorEmojiMaker/emoji")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEmojiData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.emojimaker.horor.emoji.data.model.emoji.EmojiApiResponse>> $completion);
}