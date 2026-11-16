# I-Bond Rates API - Dart/Flutter Client

I-Bond Rates provides current and historical interest rates for US Series I Savings Bonds. I-Bonds are inflation-protected savings bonds with a composite rate made up of a fixed rate plus an inflation rate that adjusts every 6 months.

[![pub package](https://img.shields.io/pub/v/apiverve_savingsbonds.svg)](https://pub.dev/packages/apiverve_savingsbonds)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [I-Bond Rates API](https://apiverve.com/marketplace/savingsbonds?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_savingsbonds: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_savingsbonds/apiverve_savingsbonds.dart';

void main() async {
  final client = SavingsbondsClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'period': '2024-11'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "period": "2026-10",
    "compositeRate": 4.26,
    "fixedRate": 0.9,
    "inflationRate": 1.67,
    "purchaseLimit": 10000,
    "minimumHoldingPeriod": "1 year",
    "earlyRedemptionPenalty": "Last 3 months interest if redeemed before 5 years",
    "taxAdvantages": "Federal tax deferred until redemption; exempt from state/local tax; may be tax-free for education",
    "nextRateChange": "2026-11-01",
    "lastUpdated": "2026-09-01T15:00:29.761Z"
  }
}
```

## API Reference

- **API Home:** [I-Bond Rates API](https://apiverve.com/marketplace/savingsbonds?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/savingsbonds](https://docs.apiverve.com/ref/savingsbonds?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
