declare module '@apiverve/savingsbonds' {
  export interface savingsbondsOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface savingsbondsResponse {
    status: string;
    error: string | null;
    data: I-BondRatesData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface IBondRatesData {
      iBonds:               IBonds;
      eeBonds:              EeBonds;
      recommendation:       null | string;
      recommendationReason: null | string;
      nextRateChange:       Date | null;
      lastUpdated:          Date | null;
  }
  
  interface EeBonds {
      currentRate:        number | null;
      guaranteedDoubling: null | string;
      purchaseLimit:      number | null;
  }
  
  interface IBonds {
      currentRate:   number | null;
      fixedRate:     number | null;
      inflationRate: number | null;
      purchaseLimit: number | null;
  }

  export default class savingsbondsWrapper {
    constructor(options: savingsbondsOptions);

    execute(callback: (error: any, data: savingsbondsResponse | null) => void): Promise<savingsbondsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: savingsbondsResponse | null) => void): Promise<savingsbondsResponse>;
    execute(query?: Record<string, any>): Promise<savingsbondsResponse>;
  }
}
