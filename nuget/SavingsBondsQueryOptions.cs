using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.SavingsBonds
{
    /// <summary>
    /// Query options for the Savings Bonds API
    /// </summary>
    public class SavingsBondsQueryOptions
    {
        /// <summary>
        /// Bond type: 'i' for I Bonds, 'ee' for EE Bonds. Omit for both.
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }
    }
}
