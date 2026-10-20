I-Bond Rates API
============

I-Bond Rates provides current and historical interest rates for US Series I Savings Bonds. I-Bonds are inflation-protected savings bonds with a composite rate made up of a fixed rate plus an inflation rate that adjusts every 6 months.


[![PyPI version](https://img.shields.io/pypi/v/apiverve-i-bondrates.svg)](https://pypi.org/project/apiverve-i-bondrates/)

This is a Python wrapper for the [I-Bond Rates API](https://apiverve.com/marketplace/savingsbonds?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-i-bondrates
```

Using `pip3`:

```bash
pip3 install apiverve-i-bondrates
```

---

## Configuration

Before using the I-Bond Rates API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient

# Initialize the client with your APIVerve API key
api = SavingsbondsAPIClient("[YOUR_API_KEY]")

query = { "period": "2024-11" }

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The I-Bond Rates API documentation is found here: [https://docs.apiverve.com/ref/savingsbonds](https://docs.apiverve.com/ref/savingsbonds?utm_source=pypi&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient

# Initialize the client with your APIVerve API key
api = SavingsbondsAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = { "period": "2024-11" }
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

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

---

## Error Handling

The API client provides comprehensive error handling through the `SavingsbondsAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient, SavingsbondsAPIClientError

api = SavingsbondsAPIClient("[YOUR_API_KEY]")

query = { "period": "2024-11" }

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except SavingsbondsAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient, SavingsbondsAPIClientError

api = SavingsbondsAPIClient("[YOUR_API_KEY]")

query = { "period": "2024-11" }

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except SavingsbondsAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient, SavingsbondsAPIClientError

query = { "period": "2024-11" }

# Using context manager ensures proper cleanup
with SavingsbondsAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except SavingsbondsAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient

# Enable debug mode
api = SavingsbondsAPIClient("[YOUR_API_KEY]", debug=True)

query = { "period": "2024-11" }

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_i-bondrates.apiClient import SavingsbondsAPIClient

api = SavingsbondsAPIClient("[YOUR_API_KEY]")

query = { "period": "2024-11" }

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
