# I-Bond Rates API - Ruby Gem

I-Bond Rates provides current and historical interest rates for US Series I Savings Bonds. I-Bonds are inflation-protected savings bonds with a composite rate made up of a fixed rate plus an inflation rate that adjusts every 6 months.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_savingsbonds'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_savingsbonds
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_savingsbonds'

# Initialize the client
client = APIVerve::Savingsbonds::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ period: "2024-11" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ period: "2024-11" })
  puts response["data"]
rescue APIVerve::Savingsbonds::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Savingsbonds::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Savingsbonds::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/savingsbonds?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/savingsbonds?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/savingsbonds?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
