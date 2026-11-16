/// Response models for the I-Bond Rates API.

/// API Response wrapper.
class SavingsbondsResponse {
  final String status;
  final dynamic error;
  final SavingsbondsData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  SavingsbondsResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory SavingsbondsResponse.fromJson(Map<String, dynamic> json) => SavingsbondsResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? SavingsbondsData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the I-Bond Rates API.

class SavingsbondsData {
  String? period;
  num? compositeRate;
  num? fixedRate;
  num? inflationRate;
  num? purchaseLimit;
  String? minimumHoldingPeriod;
  String? earlyRedemptionPenalty;
  String? taxAdvantages;
  String? nextRateChange;
  String? lastUpdated;

  SavingsbondsData({
    this.period,
    this.compositeRate,
    this.fixedRate,
    this.inflationRate,
    this.purchaseLimit,
    this.minimumHoldingPeriod,
    this.earlyRedemptionPenalty,
    this.taxAdvantages,
    this.nextRateChange,
    this.lastUpdated,
  });

  factory SavingsbondsData.fromJson(Map<String, dynamic> json) => SavingsbondsData(
      period: json['period'],
      compositeRate: json['compositeRate'],
      fixedRate: json['fixedRate'],
      inflationRate: json['inflationRate'],
      purchaseLimit: json['purchaseLimit'],
      minimumHoldingPeriod: json['minimumHoldingPeriod'],
      earlyRedemptionPenalty: json['earlyRedemptionPenalty'],
      taxAdvantages: json['taxAdvantages'],
      nextRateChange: json['nextRateChange'],
      lastUpdated: json['lastUpdated'],
    );
}

class SavingsbondsRequest {
  String? period;

  SavingsbondsRequest({
    this.period,
  });

  Map<String, dynamic> toJson() => {
      if (period != null) 'period': period,
    };
}
