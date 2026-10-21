using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.IBondRates
{
    /// <summary>
    /// Query options for the I-Bond Rates API
    /// </summary>
    public class IBondRatesQueryOptions
    {
        /// <summary>
        /// Specific issue period to lookup (YYYY-MM format, e.g., 2024-11). Omit for current rates.
        /// </summary>
        [JsonProperty("period")]
        public string Period { get; set; }
    }
}
