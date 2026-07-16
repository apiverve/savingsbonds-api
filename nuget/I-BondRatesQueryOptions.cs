using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.I-BondRates
{
    /// <summary>
    /// Query options for the I-Bond Rates API
    /// </summary>
    public class I-BondRatesQueryOptions
    {
        /// <summary>
        /// Specific issue period to lookup (YYYY-MM format, e.g., 2024-11). Omit for current rates.
        /// </summary>
        [JsonProperty("period")]
        public string Period { get; set; }
    }
}
