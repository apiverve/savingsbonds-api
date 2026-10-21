# I-Bond Rates API - PHP Package

I-Bond Rates provides current and historical interest rates for US Series I Savings Bonds. I-Bonds are inflation-protected savings bonds with a composite rate made up of a fixed rate plus an inflation rate that adjusts every 6 months.

## Installation

Install via Composer:

```bash
composer require apiverve/savingsbonds
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Savingsbonds\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['period' => '2024-11']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Savingsbonds\Client;
use APIVerve\Savingsbonds\Exceptions\APIException;
use APIVerve\Savingsbonds\Exceptions\ValidationException;

try {
    $response = $client->execute(['period' => '2024-11']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/savingsbonds?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/savingsbonds?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/savingsbonds?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
