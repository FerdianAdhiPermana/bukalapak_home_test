package com.android.myapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("active") var active: Boolean? = false,
    @SerializedName("alternative_image") var alternativeImage: String? = "",
    @SerializedName("assurance") var assurance: Boolean? = false,
    @SerializedName("brand") var brand: Boolean? = false,
    @SerializedName("category") var category: String? = "",
    @SerializedName("category_id") var categoryId: Int? = 0,
    @SerializedName("category_structure") var categoryStructure: List<String?>? = listOf(),
    @SerializedName("city") var city: String? = "",
    @SerializedName("condition") var condition: String? = "",
    @SerializedName("courier") var courier: List<String?>? = listOf(),
    @SerializedName("created_at") var createdAt: String? = "",
    @SerializedName("current_product_sku_id") var currentProductSkuId: Long? = 0,
    @SerializedName("current_variant_name") var currentVariantName: String? = "",
    @SerializedName("deal_info") var dealInfo: DealInfo? = DealInfo(),
    @SerializedName("deal_request_state") var dealRequestState: String? = "",
    @SerializedName("desc") var desc: String? = "",
    @SerializedName("favorited") var favorited: Boolean? = false,
    @SerializedName("for_sale") var forSale: Boolean? = false,
    @SerializedName("force_insurance") var forceInsurance: Boolean? = false,
    @SerializedName("has_bundling") var hasBundling: Boolean? = false,
    @SerializedName("id") var id: String? = "",
    @SerializedName("image_ids") var imageIds: List<Int?>? = listOf(),
    @SerializedName("images") var images: List<String?>? = listOf(),
    @SerializedName("imported") var imported: Boolean? = false,
    @SerializedName("interest_count") var interestCount: Int? = 0,
    @SerializedName("labels") var labels: List<Label?>? = listOf(),
    @SerializedName("last_order_schedule") var lastOrderSchedule: LastOrderSchedule? = LastOrderSchedule(),
    @SerializedName("last_relist_at") var lastRelistAt: String? = "",
    @SerializedName("max_quantity") var maxQuantity: Int? = 0,
    @SerializedName("min_quantity") var minQuantity: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("negotiation") var negotiation: Negotiation? = Negotiation(),
    @SerializedName("new_image_ids") var newImageIds: List<Long?>? = listOf(),
    @SerializedName("on_bundling") var onBundling: Boolean? = false,
    @SerializedName("on_daily_deal") var onDailyDeal: Boolean? = false,
    @SerializedName("premium_account") var premiumAccount: Boolean? = false,
    @SerializedName("price") var price: Int? = 0,
    @SerializedName("province") var province: String? = "",
    @SerializedName("rating") var rating: Rating? = Rating(),
    @SerializedName("rush_delivery") var rushDelivery: Boolean? = false,
    @SerializedName("seller_avatar") var sellerAvatar: String? = "",
    @SerializedName("seller_delivery_time") var sellerDeliveryTime: String? = "",
    @SerializedName("seller_id") var sellerId: Int? = 0,
    @SerializedName("seller_level") var sellerLevel: String? = "",
    @SerializedName("seller_level_badge_url") var sellerLevelBadgeUrl: String? = "",
    @SerializedName("seller_name") var sellerName: String? = "",
    @SerializedName("seller_negative_feedback") var sellerNegativeFeedback: Int? = 0,
    @SerializedName("seller_positive_feedback") var sellerPositiveFeedback: Int? = 0,
    @SerializedName("seller_term_condition") var sellerTermCondition: String? = "",
    @SerializedName("seller_username") var sellerUsername: String? = "",
    @SerializedName("sla_display") var slaDisplay: Int? = 0,
    @SerializedName("sla_display_raw") var slaDisplayRaw: Int? = 0,
    @SerializedName("sla_type") var slaType: String? = "",
    @SerializedName("sla_type_raw") var slaTypeRaw: String? = "",
    @SerializedName("small_images") var smallImages: List<String?>? = listOf(),
    @SerializedName("sold_count") var soldCount: Int? = 0,
    @SerializedName("specs") var specs: Specs? = Specs(),
    @SerializedName("stock") var stock: Int? = 0,
    @SerializedName("tag_pages") var tagPages: List<TagPage?>? = listOf(),
    @SerializedName("top_merchant") var topMerchant: Boolean? = false,
    @SerializedName("updated_at") var updatedAt: String? = "",
    @SerializedName("url") var url: String? = "",
    @SerializedName("view_count") var viewCount: Int? = 0,
    @SerializedName("waiting_payment") var waitingPayment: Int? = 0,
    @SerializedName("weight") var weight: Int? = 0
) : Parcelable

@Parcelize
data class DealInfo(
    @SerializedName("discount_date") var discountDate: String? = "",
    @SerializedName("discount_expired_date") var discountExpiredDate: String? = "",
    @SerializedName("discount_percentage") var discountPercentage: Int? = 0,
    @SerializedName("discount_price") var discountPrice: Int? = 0,
    @SerializedName("original_price") var originalPrice: Int? = 0,
    @SerializedName("state") var state: String? = ""
) : Parcelable

@Parcelize
data class Label(
    @SerializedName("description") var description: String? = "",
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = "",
    @SerializedName("slug") var slug: String? = ""
) : Parcelable

@Parcelize
data class LastOrderSchedule(
    @SerializedName("1") var x1: String? = "",
    @SerializedName("2") var x2: String? = "",
    @SerializedName("3") var x3: String? = "",
    @SerializedName("4") var x4: String? = "",
    @SerializedName("5") var x5: String? = ""
) : Parcelable

@Parcelize
data class Negotiation(
    @SerializedName("active") var active: Boolean? = false,
    @SerializedName("end_time") var endTime: String? = String(),
    @SerializedName("max_deduction") var maxDeduction: Int? = 0,
    @SerializedName("start_time") var startTime: String? = String()
) : Parcelable

@Parcelize
data class Rating(
    @SerializedName("average_rate") var averageRate: String? = "",
    @SerializedName("user_count") var userCount: Int? = 0
) : Parcelable

@Parcelize
data class Specs(
    @SerializedName("brand") var brand: String? = ""
) : Parcelable

@Parcelize
data class TagPage(
    @SerializedName("has_landing_page") var hasLandingPage: Boolean? = false,
    @SerializedName("id") var id: Int? = 0,
    @SerializedName("name") var name: String? = ""
) : Parcelable